package cn.leetcode;

public class Test543 {
    //543. 二叉树的直径

    /**
     * 给你一棵二叉树的根节点，返回该树的 直径 。
     * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
     * 两节点之间路径的 长度 由它们之间边数表示。
     * 示例 1：
     * 输入：root = [1,2,3,4,5]
     * 输出：3
     * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
     * 示例 2：
     * 输入：root = [1,2]
     * 输出：1
     * 提示：
     * 树中节点数目在范围 [1, 104] 内
     * -100 <= Node.val <= 100
     */

    public static void main(String[] args) {
        Test543 test543 = new Test543();
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(test543.new Solution().diameterOfBinaryTree(treeNode));

    }

    class Solution {
        int ans;
        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            depth(root);
            return ans - 1;
        }
        public int depth(TreeNode node) {
            if (node == null) {
                return 0; // 访问到空节点了，返回0
            }
            int L = depth(node.left); // 左儿子为根的子树的深度
            int R = depth(node.right); // 右儿子为根的子树的深度
            ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
            return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
        }
    }


}
