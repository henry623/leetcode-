package Test;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class pdd2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long X = in.nextLong();
        //na n-1 a
        int[] c  = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }

        long[] w = new long[n];
        for (int i = 0; i < n; i++) {
            w[i] = (long)c[i] * (n - i);

        }
        Arrays.sort(w);
        long sum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if(sum+w[i]<=X){
                sum+=w[i];
                count++;
            }else{
                break;
            }
        }
        System.out.println(count);

    }
}