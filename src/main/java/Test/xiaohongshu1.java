package Test;

import java.util.Scanner;

public class xiaohongshu1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0){
            long x = in.nextLong();
            System.out.println(isPerfect(x) ? "YES" : "NO");
        }
    }

    private static boolean isPerfect(long x) {
        for(int k =3;;k++){
            long temp = 1;
            boolean flag = false;
            for (int i = 1; i <= k; i++) {
                if(temp>x/i){
                    flag = true;
                    break;
                }
                temp *=i;
            }
            if(flag ||temp >x){
                break;
            }
            for(long a =1;;a++){
                long temp2 = 1;
                boolean flag2 = false;
                for (int i = 0; i < k; i++) {
                    long num = a+i;
                    if(temp2>x/num){
                        flag2 = true;
                        break;
                    }
                    temp2 *=num;
                }
                if(flag2){
                    break;
                }
                if(temp2 == x){
                    return true;
                }
                if(temp2 > x){
                    break;
                }
            }
        }
        return false;
    }
}
