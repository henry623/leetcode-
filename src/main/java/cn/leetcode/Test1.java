package cn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test1 {
    //1. 两数之和
    /**给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
     你可以按任意顺序返回答案。
     示例 1：
     输入：nums = [2,7,11,15], target = 9
     输出：[0,1]
     解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     示例 2：
     输入：nums = [3,2,4], target = 6
     输出：[1,2]
     示例 3：
     输入：nums = [3,3], target = 6
     输出：[0,1]
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        Test1 test1 = new Test1();
        int[] ints = test1.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
        for (int anInt : ints) {
            System.out.println(anInt);
        }


    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}



