package Test;

import java.util.*;

public class oppo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 14 = 9 + 5
        // x - w =
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        Arrays.sort(w);
        int left = w[0];
        int right = w[n - 1];
        for (int i = 0; i < right - left; i++) {
            if (right - left <= 2) {
                int mid1 = left + (right - left) / 3;
                int mid2 = right - (right - left) / 3;

                long cost1 = calculateCost(mid1, w, a, b, c, d);
                long cost2 = calculateCost(mid1, w, a, b, c, d);
                if (cost1 < cost2) {
                    right = mid2;
                } else {
                    left = mid1;
                }
            }
        }
        long minCost = Long.MAX_VALUE;
        for (int t = 0; t < right - left; t++) {
            long cost = calculateCost(t + left, w, a, b, c, d);
            if (cost < minCost) {
                minCost = cost;
            }
        }
        System.out.println(minCost);

    }

    public static long calculateCost(int target, int[] w, int a, int b, int c,
                                     int d) {
        long total = 0;
        for (int num : w) {
            int delta = target - num;
            total += analyzeCost(delta, w, a, b, c, d);

        }
        return total;
    }

    public static long analyzeCost(int delta, int[] w, int a, int b, int c,
                                   int d) {
        if (delta == 0) return 0;
        long cost = Long.MAX_VALUE;
        if (delta > 0) {
            if (b < 2 * a) {
                int twoSteps = delta / 2;
                int oneStep = delta % 2;

                cost = Math.min(cost, (long) twoSteps * b + oneStep * a);
            } else {
                cost = Math.min(cost, (long)delta * a);
            }
        } else {
            int k = -delta;
            if (d < 2 * c) {
                int twoSteps = k / 2;
                int oneStep = k % 2;
                cost = Math.min(cost, (long) twoSteps * d + oneStep * c);
            } else {
                cost = Math.min(cost, (long)delta * c);
            }
        }

        for (int i = 0; i < w[w.length - 1] - w[0]; i++) {
            int j = i - delta;
            if (j < 0) continue;
            long addCost = AddCost(i, a, b);
            long reduceCost = ReduceCost(j, c, d);

            cost = Math.min(cost, addCost + reduceCost);
        }

        for (int i = 0; i < w[w.length - 1] - w[0]; i++) {
            int j = i + delta;
            if (j < 0) continue;

            long reduceCost = ReduceCost(i, c, d);
            long addCost = AddCost(j, a, b);

            cost = Math.min(cost, addCost + reduceCost);
        }
        return cost;

    }

    private static long AddCost(int k, int a, int b) {
        // TODO
        if (k == 0) return 0;
        if (b < 2 * a) {
            int twoSteps = k / 2;
            int oneStep = k % 2;
            return (long) twoSteps * b + oneStep * a;
        } else {
            return (long)k * a;
        }

    }

    private static long ReduceCost(int k, int c, int d) {
        // TODO
        if (k == 0) return 0;
        if (d < 2 * c) {
            int twoSteps = k / 2;
            int oneStep = k % 2;
            return (long) twoSteps * d + oneStep * c;
        } else {
            return (long)k * c;
        }
    }
}
