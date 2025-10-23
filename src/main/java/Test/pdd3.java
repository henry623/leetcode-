package Test;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class pdd3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long T = in.nextLong();
        long[] s = new long[N];
        int[] d = new int[N];
        int maxd =0;
        for(int i = 0;i<N;i++){
            s[i] = in.nextLong();
            d[i] = in.nextInt();
            if(d[i]>maxd){
                maxd = d[i];
            }
        }
        int left = 1,right=maxd;
        int ans = maxd;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(check(mid,s,d,T)){
                ans =mid;
                right=mid -1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(ans);

    }

    private static boolean check(int mid, long[] s, int[] d, long T) {
        // TODO
        long cur = 0;
        for(int i=0;i<d.length;i++){
            if(d[i]>mid){
                cur =0;
                continue;
            }
            if(cur>Long.MAX_VALUE - s[i]){
                return true;
            }
            if(T-cur<=s[i]){
                return true;
            }
            cur +=s[i];
        
        }
        return false;
    }

    
}