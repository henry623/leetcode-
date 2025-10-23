package Test;

import java.util.Scanner;

public class baidu3 {
    static final int Mod = 1000000007;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0){
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            String s = in.next();

            long result = Solution(n, m, k, s);
            System.out.println(result);
        }
    }

    private static long Solution(int n, int m, int k, String s) {
        int t = n/2;
        boolean[] isPair = new boolean[t];
        for (int i = 0; i < t; i++) {
            int j = n-i-1;
            isPair[i] = (s.charAt(i) == s.charAt(j));
        }
        long[][][] dp = new long[t+1][m+1][t+1];
        dp[0][0][0] = 1;
        for (int i = 0; i < t; i++) {
            for (int j = 0; j <= m; j++) {
                for (int h = 0; h <= t; h++) {
                   if(dp[i][j][h] == 0) continue;
                   if(isPair[i]){
                       dp[i+1][j][h+1] = (dp[i][j][h] + dp[i+1][j][h+1])% Mod;
                       if(j+1 <=m){
                           dp[i+1][j+1][h] = (2*dp[i][j][h] + dp[i+1][j+1][h])% Mod;
                       }
                       if(j+2<=m){
                           dp[i+1][j+2][h+1] = (dp[i][j][h] + dp[i+1][j+2][h+1])% Mod;
                       }

                   }else{
                       dp[i+1][j][h] = (dp[i][j][h] + dp[i+1][j][h])% Mod;
                       if(j+1 <=m){
                           dp[i+1][j+1][h+1] = (2*dp[i][j][h] + dp[i+1][j+1][h+1])% Mod;
                       }
                       if(j+2<=m){
                           dp[i+1][j+2][h] = (dp[i][j][h] + dp[i+1][j+2][h])% Mod;
                       }
                   }
                }
            }
        }
        long result = 0;

        for (int i = 0; i <= m; i++) {
            result = (result+  dp[t][i][k])% Mod;
        }
        return result;
    }
}
