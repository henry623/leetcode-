package Test;

import java.util.Scanner;

public class SF2 {
    public static void main(String[] args) {
        //729 25  11x 1x1 x11 9*3 -2 =25
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n==1) {
            System.out.println(9);
            return;
        }
        long[][] dp = new long[2][2];
        dp[0][0] = 64;
        dp[0][1] = 8;
        dp[1][0] = 8;
        dp[1][1] = 0;
        long Mod = 1000000007;

        for(int i=3;i<=n;i++){
            long[][] newDp = new long[2][2];
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                    long count = dp[j][k];
                    if(count==0){
                        continue;
                    }
                    newDp[k][0] = (newDp[k][0] + count*8)%Mod;
                    if(j==0&& k==0){
                        newDp[k][1] = (newDp[k][1] + count)%Mod;
                    }
                }
            }
            dp = newDp;
        }
        long ans = (dp[0][0]+dp[0][1]+dp[1][0]+dp[1][1])%Mod;
        System.out.println(ans);

    }
}
