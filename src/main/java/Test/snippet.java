package Test;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class snippet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- >0){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            int[] pos = new int[n+1];
            for(int i =0;i<n;i++){
                a[i] = in.nextInt();
                pos[a[i]] =i;
            }

            for(int i =0;i<n && m>0;i++){
                int target = i+1;
                int j = pos[target];
                if(j==i) continue;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;

                pos[temp] =j;
                pos[target] =i;
                m--;
            }
            StringBuilder sb = new StringBuilder();
            for(int num:a){
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}