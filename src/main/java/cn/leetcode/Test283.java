package cn.leetcode;

public class Test283 {
    // 283. 移动零

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 示例 2:
     * <p>
     * 输入: nums = [0]
     * 输出: [0]
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 104
     * -231 <= nums[i] <= 231 - 1
     */
    public static void main(String[] args) {
//        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] nums = new int[]{1};
//        int[] nums = new int[]{0, 1, 3, 5, 6, 7, 8, 8, 0, 0, 0, 9, 0};
//        int[] nums = new int[]{2, 1, 0, 0, 12, 3};
        Test283 test283 = new Test283();
        test283.moveZeroes2(nums);
//        test283.solution2(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void solution(int[] nums) {
        int n = nums.length, flag = 0;
        //用flag检测非0的个数
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[flag] = nums[i];
                flag++;
            }
        }
        for (int i = flag; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /*//无法验证只输入0的情况(验证了) 但无法满足保持非零元素的相对顺序
    public void solution2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return;
        }
        int j = 0;
        for (int i = 0; i < n - j; i++) {
            if (nums[i] == 0) {
                while (nums[n - i - j - 1] == 0) {
                    j++;
                    if (j == i + 1) {
                        break;
                    }
                }
                nums[i] = nums[n - j - 1];
                nums[n - j - 1] = 0;
            }

        }

    }*/


    public void moveZeroes2(int[] nums) {
        int offset = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                offset++;
            } else if (offset != 0) {
                nums[i - offset] = nums[i];
                nums[i] = 0;
            }
        }
    }


}
