package Test;

import java.util.*;

public class didi4 {
    static class Tower {
        int r, v, a;

        Tower(int r, int v, int a) {
            this.r = r;
            this.v = v;
            this.a = a;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int L = in.nextInt();
            List<Tower> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int r = in.nextInt();
                int v = in.nextInt();
                int a = in.nextInt();
                list.add(new Tower(r, v, a));
            }
            Collections.sort(list, (a, b) -> a.r - b.r);
            long[] dp = new long[L + 1];
            Arrays.fill(dp, Long.MAX_VALUE / 2);
            dp[0] = 0;
            long ans = Long.MAX_VALUE / 2;
            for (Tower t : list) {
                long M = (2L * t.r + 1) * (2L * t.r + 1) - 1;
                long[] oldDp = Arrays.copyOf(dp, L + 1);
                for (int i = L - 1; i >= 0; i--) {
                    if (oldDp[i] >= Long.MAX_VALUE / 2) {
                        continue;
                    }
                    for (int j = 1; j <= Math.min(t.a, L - i); j++) {
                        long newCost = oldDp[i] + (long) j * t.v;
                        if (newCost < dp[i + j]) {
                            dp[i + j] = newCost;
                        }
                    }
                }
                if (M >= L && t.a > 0) {
                    if (dp[L] < oldDp[L]) {
                        ans = Math.min(ans, dp[L]);
                    } else {
                        long[] dp2 = Arrays.copyOf(oldDp, L);
                        for (int i = L - 2; i >= 0; i--) {
                            if (oldDp[i] > Long.MAX_VALUE / 2) {
                                continue;
                            }
                            for (int j = 1; j <= Math.min(t.a - 1, L - i - 1); j++) {
                                long newCost = oldDp[i] + (long) j * t.v;
                                if (newCost < dp2[i + j]) {
                                    dp2[i + j] = newCost;
                                }
                            }
                        }
                        if(dp2[L-1]<Long.MAX_VALUE/2){
                            ans = Math.min(ans, dp2[L-1] + t.v);
                        }
                    }
                }
            }
            if(ans >= Long.MAX_VALUE / 2){
                System.out.println(-1);
            }else {
                System.out.println(ans);
            }
        }
    }
}
