package Test;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class pdd1{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] nums = new long[n];
        int[] cnt = new int[m];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextLong();
            int r = (int) (nums[i] % m);
            cnt[r]++;
        }
        final int MOD = 998244353;
        long ans = 0;
        long cnt0 = (long)cnt[0]*(cnt[0] -1) /2;
        ans = ans+ cnt0;
        if(m%2==0){
            int half = m/2;
            ans = ans + (long)cnt[half]*(cnt[half]-1)/2;
        }
        int end = (m-1)/2;
        for (int i = 1; i <= end; i++) {
           int comp = m-i;
           if(i!=comp){
            ans += (long)cnt[i]*cnt[comp];
           }
        }
        
        System.out.println(ans%MOD);

    }
    
}
