package cn.leetcode;

import java.util.*;

public class Test199 {
    //  199. 二叉树的右视图

    /**
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * 示例 1：
     * 输入：root = [1,2,3,null,5,null,4]
     * 输出：[1,3,4]
     * 解释：
     * 示例 2：
     * 输入：root = [1,2,3,4,null,null,null,5]
     * 输出：[1,3,4,5]
     * 解释：
     * 示例 3：
     * 输入：root = [1,null,3]
     * 输出：[1,3]
     * 示例 4：
     * 输入：root = []
     * 输出：[]
     * 提示:
     * 二叉树的节点个数的范围是 [0,100]
     * -100 <= Node.val <= 100
     */

    public static void main(String[] args) {
        Test199 test199 = new Test199();
        List<Integer> integers = test199.new Solution().rightSideView(new TreeNode(1, new TreeNode(2,null, new TreeNode(5)), new TreeNode(3,null, new TreeNode(4))));
        System.out.println(integers);
    }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
            int max_depth = -1;

            Deque<TreeNode> nodeStack = new LinkedList<TreeNode>();
            Deque<Integer> depthStack = new LinkedList<Integer>();
            nodeStack.push(root);
            depthStack.push(0);

            while (!nodeStack.isEmpty()) {
                TreeNode node = nodeStack.pop();
                int depth = depthStack.pop();

                if (node != null) {
                    // 维护二叉树的最大深度
                    max_depth = Math.max(max_depth, depth);

                    // 如果不存在对应深度的节点我们才插入
                    if (!rightmostValueAtDepth.containsKey(depth)) {
                        rightmostValueAtDepth.put(depth, node.val);
                    }

                    nodeStack.push(node.left);
                    nodeStack.push(node.right);
                    depthStack.push(depth + 1);
                    depthStack.push(depth + 1);
                }
            }

            List<Integer> rightView = new ArrayList<Integer>();
            for (int depth = 0; depth <= max_depth; depth++) {
                rightView.add(rightmostValueAtDepth.get(depth));
            }

            return rightView;
        }
    }

    class Solution2 {
        public List<Integer> rightSideView(TreeNode root) {
            Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
            int max_depth = -1;

            Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
            Queue<Integer> depthQueue = new LinkedList<Integer>();
            nodeQueue.add(root);
            depthQueue.add(0);

            while (!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.remove();
                int depth = depthQueue.remove();

                if (node != null) {
                    // 维护二叉树的最大深度
                    max_depth = Math.max(max_depth, depth);

                    // 由于每一层最后一个访问到的节点才是我们要的答案，因此不断更新对应深度的信息即可
                    rightmostValueAtDepth.put(depth, node.val);

                    nodeQueue.add(node.left);
                    nodeQueue.add(node.right);
                    depthQueue.add(depth + 1);
                    depthQueue.add(depth + 1);
                }
            }

            List<Integer> rightView = new ArrayList<Integer>();
            for (int depth = 0; depth <= max_depth; depth++) {
                rightView.add(rightmostValueAtDepth.get(depth));
            }

            return rightView;
        }
    }


}
