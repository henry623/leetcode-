package Test;

import java.util.*;

public class xiaohongshu2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        final int temp = 500000;
        int[] nums = new int[temp+1];
        for(int i = 0; i < n; i++){
            int a = in.nextInt();
            if(a<=temp){
                nums[a]++;
            }
        }
        int[] D = new int[temp+1];
        for (int i = 1; i <= temp; i++) {
            if(nums[i] ==0) continue;
            for(int x =i;x<=temp;x+=i){
                D[x] += nums[i];
            }
        }

        int[] F = new int[temp+1];
        for (int i = 1; i <= temp; i++) {
            for(int x =i;x<=temp;x+=i){
                F[i] += nums[x];
            }
        }
        for(int i = 0; i < m; i++){
            int a = in.nextInt();
            if(a>temp){
                System.out.println(0);
            }else{
                int result = D[a] + F[a] - nums[a];
                System.out.println(result);
            }
        }
    }
}
