package Test;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class oppo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        int[] a = new int[n];

        for(int i =0; i<n ;i++){
            a[i] = in.nextInt();
        }

        int target = x^y;

        HashSet<Integer> nums = new HashSet<>();

        for(int num : a){
            int temp = target - num;
            if(nums.contains(temp)){
                System.out.println("Yes");
                return;
            }
            nums.add(num);
        }
        System.out.println("No");


    }
}