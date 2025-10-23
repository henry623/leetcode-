package Test;

import java.util.Scanner;

public class didi3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        long dp0 = 0;
        long dp1 = Long.MAX_VALUE/2;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            long newDP0 = Long.MAX_VALUE/2;
            long newDP1 = Long.MAX_VALUE/2;

            if(dp0<Long.MAX_VALUE/2){
                if(ch == 'R'){
                    newDP0 = Math.min(newDP0, dp0+a);
                    newDP1 = Math.min(newDP1, dp0+c+b);
                }else{
                    newDP0 = Math.min(newDP0, dp0+b);
                    newDP1 = Math.min(newDP1, dp0+c+a);
                }
            }

            if(dp1<Long.MAX_VALUE/2){
                if(ch == 'R'){
                    newDP1 = Math.min(newDP1, dp1+b);
                    newDP0 = Math.min(newDP0, dp1+c+a);
                }else{
                    newDP1 = Math.min(newDP1, dp1+a);
                    newDP0 = Math.min(newDP0, dp1+c+b);
                }
            }

            dp0 = newDP0;
            dp1 = newDP1;
        }
        System.out.println(Math.min(dp0, dp1));

    }
}
