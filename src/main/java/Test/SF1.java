package Test;

import java.util.*;

public class SF1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            int[] pos = new int[n + 1];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                pos[a[i]] = i;
            }
            int[] b = new int[n];
            int[] c = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
                c[i] = pos[b[i]];
            }
            int L = 1;
            for(int i = n-2;i>0;i--){
                if(c[i]<c[i+1]){
                    L++;
                }else{
                    break;
                }
            }
            System.out.println(n-L);
        }
    }
}
