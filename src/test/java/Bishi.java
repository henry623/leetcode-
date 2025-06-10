import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bishi {

    static class Edge {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Edge>[] tree;
    static long[][] dp;

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

        dp = new long[n + 1][3];
        dfs(1,-1 );
        System.out.println(dp[1][0]);

    }

    static void dfs(int u, int parent) {
        List<Long> gains = new ArrayList<>();
        for (Edge edge : tree[u]) {
            int v = edge.to;
            if (v == parent) continue;
            dfs(v, u);
            gains.add(edge.weight + dp[v][1]);
            gains.add(dp[v][0]);

        }

        Collections.sort(gains, Collections.reverseOrder());

        long sum = 0;
        for (int i = 0; i < Math.min(2, gains.size()); i++) {
            sum += gains.get(i);
        }
        dp[u][0] = sum;

        sum = 0;
        if (!gains.isEmpty()) {
            sum = gains.get(0);
        }
        dp[u][1] = sum;

        sum = 0;
        for (int i = 0; i < Math.min(2, gains.size()); i++) {
            sum += gains.get(i);
        }
        dp[u][2] = sum;
    }
}



