import java.util.*;

public class Bishi4 {
    static final int MOD = 998244353;
    static int[] parent;
    static int[] size;
    static long[] fact;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            parent[fy] = fx;
            size[fx] += size[fy];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (a[i] != -1) {
                valueToIndex.put(a[i], i);
            }
        }

        parent = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        List<Integer> elements = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] != -1) {
                elements.add(a[i]);
            }
        }

        elements.sort((x, y) -> Integer.compare(valueToIndex.get(y), valueToIndex.get(x)));

        for (int x : elements) {
            int p = valueToIndex.get(x);
            int h = x % n;
            int current = h;
            while (true) {
                if (a[current] == -1) break;
                int other = a[current];
                int otherP = valueToIndex.get(other);
                if (otherP < p) {
                    union(p, otherP);
                }
                current = (current + 1) % n;
                if (current == p) break;
            }
        }

        fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        long result = 1;
        Set<Integer> visited = new HashSet<>();
        for (int x : elements) {
            int p = valueToIndex.get(x);
            int root = find(p);
            if (!visited.contains(root)) {
                result = result * fact[size[root]] % MOD;
                visited.add(root);
            }
        }

        System.out.println(result);
    }
}