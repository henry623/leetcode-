package Test;

import java.util.*;

public class sangfor2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] graph = new int[n][n];
        int total = 0;
        for(int i =0;i<k;i++){
            int a = in.nextInt() -1;
            int b = in.nextInt() -1;
            int w = in.nextInt();
            graph[a][b] += w;
            graph[b][a] += w;
            total += w;
        }

        int totalStates = 1<<n;
        int[] f = new int[totalStates];
        for(int i = 0;i<totalStates;i++){
            for (int j = 0; j < n; j++) {
               if((i & (1<<j)) !=0){
                   for (int l = j+1; l < n; l++) {
                       if((i & (1<<l)) !=0){
                           f[i] += graph[j][l];
                       }
                   }
               }
            }
        }
        int[] dp = new int[totalStates];
        for(int i = 1;i<totalStates;i++){
            dp[i] =0;
            for(int j =i;j>0;j=(j-1)&i){
                int count = Integer.bitCount(j);
                if(count<=m){
                    dp[i] = Math.max(dp[i],f[j]+dp[i^j]);
                }
            }
        }
        System.out.println(total-dp[totalStates-1]);
    }
}
