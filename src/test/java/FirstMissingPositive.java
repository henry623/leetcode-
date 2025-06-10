public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 先将数组中小于等于0的数替换为n + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        // 遍历数组，将在1到n范围内的数对应的下标位置的数变为负数
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        // 遍历数组，找到第一个正数所在的下标，其下标加1就是未出现的最小正整数
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 如果遍历完数组都没有找到正数，说明1到n的正整数都出现了，返回n + 1
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 0};
        System.out.println(firstMissingPositive(nums1));

        int[] nums2 = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums2));

        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(nums3));
    }
}