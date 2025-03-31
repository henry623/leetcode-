package cn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test560 {
    //560. 和为K的子数组
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     * 子数组是数组中元素的连续非空序列。
     * 示例 1：
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * 示例 2：
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     * 提示：
     * 1 <= nums.length <= 2 * 104
     * -1000 <= nums[i] <= 1000
     * -107 <= k <= 107
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        int k = 1;
        Test560 test560 = new Test560();
        int i = test560.subarraySum3(nums, k);
        System.out.println(i);
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    //merge的使用
//    function mergeWithSum(map, key, value, sumFunction):
//    if key is not in map:
//    map[key] = value
//    else:
//    map[key] = sumFunction(map[key], value)
//
//// 示例使用
//    map = new HashMap()
//    key = sj
//            value = 1
//    sumFunction = Integer::sum
//
//// 第一次调用
//    mergeWithSum(map, key, value, sumFunction) // 假设 sj = 1
//// map 现在是 {1: 1}
//
//    // 第二次调用
//    mergeWithSum(map, key, value, sumFunction) // 假设 sj = 1 再次出现
//    // map 现在是 {1: 2}
    public int subarraySum3(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }

        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>(n + 1); // 设置容量可以快 2ms
        for (int sj : s) {
            ans += cnt.getOrDefault(sj - k, 0);
            cnt.merge(sj, 1, Integer::sum); // cnt[sj]++
        }
        return ans;
    }

    public int subarraySum4(int[] nums, int k) {
        int ans = 0;
        int s = 0;
        Map<Integer, Integer> cnt = new HashMap<>(nums.length + 1); // 设置容量可以快 2ms
        cnt.put(0, 1); // s[0]=0 单独统计
        for (int x : nums) {
            s += x;
            ans += cnt.getOrDefault(s - k, 0);
            cnt.merge(s, 1, Integer::sum); // cnt[s]++
        }
        return ans;
    }




}
