package cn.leetcode;

import java.util.LinkedList;

public class Test101 {
    //101. 对称二叉树

    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * 示例 1：
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     * 提示：
     * 树中节点数目在范围 [1, 1000] 内
     * -100 <= Node.val <= 100
     * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
     */

    public static void main(String[] args) {
        Test101 test101 = new Test101();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        System.out.println(test101.new Solution().isSymmetric(root));


    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root==null) {
                return true;
            }
            //调用递归函数，比较左节点，右节点
            return dfs(root.left,root.right);
        }

        boolean dfs(TreeNode left, TreeNode right) {
            //递归的终止条件是两个节点都为空
            //或者两个节点中有一个为空
            //或者两个节点的值不相等
            if(left==null && right==null) {
                return true;
            }
            if(left==null || right==null) {
                return false;
            }
            if(left.val!=right.val) {
                return false;
            }
            //再递归的比较 左节点的左孩子 和 右节点的右孩子
            //以及比较  左节点的右孩子 和 右节点的左孩子
            return dfs(left.left,right.right) && dfs(left.right,right.left);
        }
    }

    class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            if(root==null || (root.left==null && root.right==null)) {
                return true;
            }
            //用队列保存节点
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            //将根节点的左右孩子放到队列中
            queue.add(root.left);
            queue.add(root.right);
            while(queue.size()>0) {
                //从队列中取出两个节点，再比较这两个节点
                TreeNode left = queue.removeFirst();
                TreeNode right = queue.removeFirst();
                //如果两个节点都为空就继续循环，两者有一个为空就返回false
                if(left==null && right==null) {
                    continue;
                }
                if(left==null || right==null) {
                    return false;
                }
                if(left.val!=right.val) {
                    return false;
                }
                //将左节点的左孩子， 右节点的右孩子放入队列
                queue.add(left.left);
                queue.add(right.right);
                //将左节点的右孩子，右节点的左孩子放入队列
                queue.add(left.right);
                queue.add(right.left);
            }

            return true;
        }
    }

}
