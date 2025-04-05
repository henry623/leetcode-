package cn.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test41 {
    //41. 缺失的第一个正数

    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     * 示例 1：
     * 输入：nums = [1,2,0]
     * 输出：3
     * 解释：范围 [1,2] 中的数字都在数组中。
     * 示例 2：
     * 输入：nums = [3,4,-1,1]
     * 输出：2
     * 解释：1 在数组中，但 2 没有。
     * 示例 3：
     * 输入：nums = [7,8,9,11,12]
     * 输出：1
     * 解释：最小的正数 1 没有出现。
     * 提示：
     * 1 <= nums.length <= 105
     * -231 <= nums[i] <= 231 - 1
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        Test41 test41 = new Test41();
        int i = test41.firstMissingPositive(nums);
        System.out.println(i);

    }

    //空间复杂度不符合
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        for (int i = 1; i <= len ; i++) {
            if (!hashSet.contains(i)){
                return i;
            }
        }

        return len + 1;
    }

    //时间复杂度不符合
    public int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 1; i <= len; i++) {
            int res = binarySearch(nums, i);
            if (res == -1) {
                return i;
            }
        }
        return len + 1;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int firstMissingPositive3(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
