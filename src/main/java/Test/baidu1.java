package Test;

import java.util.*;

public class baidu1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        int min = nums[0];
        long result =0;
        for (int i = 1; i < n; i++) {
            if(nums[i] > 2 *min){
                int k = (nums[i] + 2*min - 1)/(2*min);
                result += k -1;
            }
        }
        System.out.println(result);



    }
}
