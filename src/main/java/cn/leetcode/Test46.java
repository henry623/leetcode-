package cn.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test46 {
    //46. 全排列

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     * 输入：nums = [1]
     * 输出：[[1]]
     * 提示：
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     */

    public static void main(String[] args) {
        Test46 test46 = new Test46();
        //Test46.WrongSolution Wrongsolution = test46.new WrongSolution();
        Test46.Solution solution = test46.new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
        //System.out.println(Wrongsolution.permute(new int[]{1, 2, 3}));

    }

    //TODO 回溯理解

    class WrongSolution {

        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            // 使用一个动态数组保存所有可能的全排列
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            boolean[] used = new boolean[len];
            List<Integer> path = new ArrayList<>();

            dfs(nums, len, 0, path, used, res);
            return res;
        }

        private void dfs(int[] nums, int len, int depth,
                         List<Integer> path, boolean[] used,
                         List<List<Integer>> res) {
            if (depth == len) {
                // 浅拷贝，path 的引用直接加进去了。
                // 后续对 path 的修改（如 path.removeLast()）会影响 res 中已经添加的元素，
                // 因为它们指向同一个对象。
                // 最终会导致所有结果都被清空或被修改成空列表。
                res.add(path);
                return;
            }

            // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    path.add(nums[i]);
                    used[i] = true;

                    dfs(nums, len, depth + 1, path, used, res);
                    // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                    used[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }

    }


    public class Solution {

        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            // 使用一个动态数组保存所有可能的全排列
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            boolean[] used = new boolean[len];
            Deque<Integer> path = new ArrayDeque<>(len);

            dfs(nums, len, 0, path, used, res);
            return res;
        }

        private void dfs(int[] nums, int len, int depth,
                         Deque<Integer> path, boolean[] used,
                         List<List<Integer>> res) {
            if (depth == len) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    path.addLast(nums[i]);
                    used[i] = true;

                    System.out.println("  递归之前 => " + path);
                    dfs(nums, len, depth + 1, path, used, res);

                    used[i] = false;
                    path.removeLast();
                    System.out.println("递归之后 => " + path);
                }
            }
        }
    }

    public class Solution2 {

        public List<List<Integer>> permute(int[] nums) {
            // 首先是特判
            int len = nums.length;
            // 使用一个动态数组保存所有可能的全排列
            List<List<Integer>> res = new ArrayList<>();

            if (len == 0) {
                return res;
            }

            boolean[] used = new boolean[len];
            List<Integer> path = new ArrayList<>();

            dfs(nums, len, 0, path, used, res);
            return res;
        }

        private void dfs(int[] nums, int len, int depth,
                         List<Integer> path, boolean[] used,
                         List<List<Integer>> res) {
            if (depth == len) {
                // 3、不用拷贝，因为每一层传递下来的 path 变量都是新建的
                res.add(path);
                return;
            }

            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    // 1、每一次尝试都创建新的变量表示当前的"状态"
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(nums[i]);

                    boolean[] newUsed = new boolean[len];
                    System.arraycopy(used, 0, newUsed, 0, len);
                    newUsed[i] = true;

                    dfs(nums, len, depth + 1, newPath, newUsed, res);
                    // 2、无需回溯
                }
            }
        }
    }


}