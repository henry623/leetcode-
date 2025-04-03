package cn.leetcode;

import java.util.*;

public class Test239 {
    //239.滑动窗口最大值
    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回 滑动窗口中的最大值 。
     * 示例 1：
     *
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     * 示例 2：
     * 输入：nums = [1], k = 1
     * 输出：[1]
     * 提示：
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     */

    public static void main(String[] args) {
        Test239 test239 = new Test239();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = test239.maxSlidingWindow(nums, 3);
        //输出数组结果
        System.out.println(Arrays.toString(result));

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 定义最大堆，按值降序排序，值相同时按索引降序排序（保证最新的元素优先）
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                //compare 默认(o1,o2) o1 - o2 < 0, 则o1排在o2前
                return pair1[0] != pair2[0] ?
                        pair2[0] - pair1[0] :  // 值大的优先
                        pair2[1] - pair1[1];   // 值相同时，索引大的优先
            }
        });

        // 初始化：将前 k 个元素加入堆
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});  // 存储值和索引
        }

        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];  // 第一个窗口的最大值

        // 滑动窗口
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});  // 添加新元素

            // 移除所有过期的堆顶元素（不在窗口 [i-k+1, i] 内的元素）
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }

            ans[i - k + 1] = pq.peek()[0];  // 当前窗口最大值
        }
        return ans;
    }


    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();  // 存储索引

        // 初始化前 k 个元素的单调队列
        for (int i = 0; i < k; ++i) {
            // 移除队尾所有小于当前元素的索引（维护单调递减）
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);  // 添加当前元素索引
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];  // 第一个窗口的最大值

        // 滑动窗口
        for (int i = k; i < n; ++i) {
            // 移除队列所有小于当前元素的索引
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);  // 添加新元素索引

            // 移除队头过期元素（不在窗口 [i-k+1, i] 内）
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            ans[i - k + 1] = nums[deque.peekFirst()];  // 当前窗口最大值
        }
        return ans;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];  // 存储块内从左到右的最大值
        int[] suffixMax = new int[n];  // 存储块内从右到左的最大值

        // 构建 prefixMax 数组
        for (int i = 0; i < n; ++i) {
            if (i % k == 0) {
                // 当前块的第一个元素，直接赋值
                prefixMax[i] = nums[i];
            } else {
                // 当前块内，取前一个 prefixMax 和当前值的较大者
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }

        // 构建 suffixMax 数组
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) {
                // 当前块的最后一个元素，直接赋值
                suffixMax[i] = nums[i];
            } else {
                // 当前块内，取后一个 suffixMax 和当前值的较大者
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        // 计算结果数组
        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            // 窗口 [i, i+k-1] 的最大值为：
            // max(当前块的后缀最大值 suffixMax[i], 下一块的前缀最大值 prefixMax[i+k-1])
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }


}
