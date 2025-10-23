package Test;

import java.util.Arrays;
import java.util.Scanner;

public class didi1 {
    // out=10
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums= new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = in.nextInt();
            nums[i][1] = in.nextInt();
        }
        int temp = 6000;
        int[] dp = new int[12001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[temp] =0;
        int minCost = Integer.MAX_VALUE;
        for(int[] num:nums){
            int a = num[0];
            int b = num[1];
            for(int j = dp.length -1;j>=0;j--){
                if (dp[j] != Integer.MAX_VALUE){
                    int next = j + a;
                    int now = j - temp;
                    if(now< -3000 || next > 3000){
                        continue;
                    }
                    int newIndex = next + now;
                    int newCost = dp[j] + b;
                    if(newCost < dp[next]){
                        dp[newIndex] =newCost;
                        if(next == temp+1){
                            if(newCost<minCost){
                                minCost = newCost;
                            }
                        }
                    }
                }
            }
        }
        if(minCost != Integer.MAX_VALUE){
            System.out.println(minCost);
        }else{
            System.out.println(-1);
        }

    }

}
