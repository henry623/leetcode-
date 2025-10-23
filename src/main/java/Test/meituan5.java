package Test;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class meituan5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0){
            int n = in.nextInt();
            int[] a = new int[n];
            long total = 0;
            for(int i = 0;i<n;i++){
                a[i] = in.nextInt();
                total += a[i];
            }
            int max_a= Arrays.stream(a).max().getAsInt();
            int bits;
            if(max_a ==0){
                bits = 1;
            }else{
                bits = 32-Integer.numberOfLeadingZeros(max_a);
            }
            long x = 0;
            for(int k =0;k<bits;k++){
                int bit = 1<<k;
                boolean hasZero = false;
                for(int i =0;i<n;i++){
                    if((a[i] & bit) ==0){
                        hasZero =true;
                        break;
                    }
                }
                if(hasZero){
                    x|=bit;
                }
            }
            long maxTotal = total + x;
            System.out.println(maxTotal + " " + x);
        }
    }
}