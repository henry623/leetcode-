package Test;


import java.util.Scanner;

public class meituan2 {


    // 注意类名必须为 Main, 不要有任何 package xxx 信息

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        long maxExp = 0;
        long[][] dp = new long[10][n + 1];
        for (int mod = 0; mod < 10; mod++) {
            for (int k = 0; k <= n; k++) {
                dp[mod][k] = Long.MIN_VALUE;
            }

        }
        dp[0][0] = 0;
        for (int k = 1; k <= n; k++) {
            for (int prevMod = 0; prevMod < 10; prevMod++) {
                if (dp[prevMod][k - 1] == Long.MIN_VALUE) {
                    continue;
                }
                if (dp[prevMod][k] < dp[prevMod][k - 1] + k) {
                    dp[prevMod][k] = dp[prevMod][k - 1] + k;
                }
                long beatExp = dp[prevMod][k - 1] + a[k - 1] * (1 + (prevMod + 1) % 10);
                int newMod = (prevMod + 1) % 10;
                if (dp[newMod][k] < beatExp) {
                    dp[newMod][k] = beatExp;
                }
            }
        }
        for (int mod = 0; mod < 10; mod++) {
            if (dp[mod][n] > maxExp) {
                maxExp = dp[mod][n];
            }
        }
        System.out.println(maxExp);

    }
}

