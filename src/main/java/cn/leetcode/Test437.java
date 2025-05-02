package cn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test437 {
    //437. 路径总和 III

    /**
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，
     * 求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，
     * 但是路径方向必须是向下的（只能从父节点到子节点）。
     * 示例 1：
     * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
     * 输出：3
     * 解释：和等于 8 的路径有 3 条，如图所示。
     * 示例 2：
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：3
     * 提示:
     * 二叉树的节点个数的范围是 [0,1000]
     * -109 <= Node.val <= 109
     * -1000 <= targetSum <= 1000
     */

    public static void main(String[] args) {
        Test437 test437 = new Test437();
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(11);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(-2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node2.right = node5;
        node1.right = node4;
        node1.left = node3;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;
        System.out.println(test437.new Solution().pathSum(root, 8));


    }

    class Solution {
        public int pathSum(TreeNode root, long targetSum) {
            if (root == null) {
                return 0;
            }

            int ret = rootSum(root, targetSum);
            ret += pathSum(root.left, targetSum);
            ret += pathSum(root.right, targetSum);
            return ret;
        }

        public int rootSum(TreeNode root, long targetSum) {
            int ret = 0;

            if (root == null) {
                return 0;
            }
            int val = root.val;
            if (val == targetSum) {
                ret++;
            }

            ret += rootSum(root.left, targetSum - val);
            ret += rootSum(root.right, targetSum - val);
            return ret;
        }
    }

    class Solution2 {
        public int pathSum(TreeNode root, int targetSum) {
            Map<Long, Integer> prefix = new HashMap<Long, Integer>();
            prefix.put(0L, 1);
            return dfs(root, prefix, 0, targetSum);
        }

        public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
            if (root == null) {
                return 0;
            }

            int ret = 0;
            curr += root.val;

            ret = prefix.getOrDefault(curr - targetSum, 0);
            prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
            ret += dfs(root.left, prefix, curr, targetSum);
            ret += dfs(root.right, prefix, curr, targetSum);
            //很重要 回溯
            prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

            return ret;
        }
    }


}
