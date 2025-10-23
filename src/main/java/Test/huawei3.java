package Test;

import java.util.Scanner;

public class huawei3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int result = Solution(nums);
        System.out.println(result);
    }

    private static int Solution(int[] nums) {
        int max = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int min = nums[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                int length = j-i+1;
                int cost = min * length;
                max = Math.max(max, cost);
            }
        }
        return max;
    }
}
