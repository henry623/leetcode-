package Test;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class pdd4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] nums = new int[N];
        for(int i=0;i<N;i++){
            nums[i] = in.nextInt();
        }
        int count =0;
        long curSum =0;
        Set<Long> set = new HashSet<>();
        set.add(0L);
        for(int i =0;i<N;i++){
            curSum = nums[i] +curSum;
            if(set.contains(curSum-M)){
                count++;
                curSum =0;
                set.clear();
                set.add(0L);
                i--;
            }else{
                set.add(curSum);
            }
        }
        System.out.println(count);

    }
}