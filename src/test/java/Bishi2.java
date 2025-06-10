import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bishi2 {

    static class Edge {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static long[] f;
    static long[] g;
    static List<Edge>[] tree;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            tree[u].add(new Edge(v, w));
            tree[v].add(new Edge(u, w));
        }

        f = new long[n + 1];
        g = new long[n + 1];
        dfs(1, -1);
        System.out.println(g[1]);

    }

    static void dfs(int u, int parent) {
        long max1 = 0;
        long max2 = 0;

        for (Edge edge : tree[u]) {
            int v = edge.to;
            if (v == parent) continue;
            dfs(v, u);
            long cur = edge.weight + f[v];

            if (cur>max1){
                max2 = max1;
                max1 = cur;
            }else if(cur>max2){
                max2 = cur;
            }

        }
        f[u] = max1;
        g[u] = max1 + max2;


    }
}




