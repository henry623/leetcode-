package Test;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class oppo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long sum=0;
        long sum_2 = 0;
        long sum_5 = 0;
        for(int i = 0;i<n;i++){
            int num = in.nextInt();
            int cnt2 =0;
            int cnt5 =0;
            while(num%2==0){
                cnt2++;
                num /= 2;
            }

            while(num %5 ==0){
                cnt5++;
                num /=5;
            }

            sum += Math.min(cnt2,cnt5);
            sum_2 +=cnt2;
            sum_5 +=cnt5;

        }
        long result = Math.max(sum,Math.max(sum_2,sum_5));
        System.out.println(result);

    }
}