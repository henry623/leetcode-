package Test;

import java.util.Scanner;

public class baidu2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0){
            int n = in.nextInt();
            int k = in.nextInt();
            String s= in.next();
            int half = k/2;
            int[] pre = new int[n+1];
            for (int i = 0; i < n; i++) {
                pre[i+1] = pre[i] + (s.charAt(i) - '0');
            }
            int count =0;
            for (int i = 0; i <= n - k; i++) {
                if(pre[i+half] - pre[i] == pre[i+k] - pre[i+half]){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
