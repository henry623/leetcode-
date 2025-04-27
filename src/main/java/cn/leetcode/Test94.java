package cn.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test94 {
    // 94. 二叉树的中序遍历

    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     * 示例 1：
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     * 输入：root = [1]
     * 输出：[1]
     * 提示：
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */

    public static void main(String[] args) {
        Test94 test94 = new Test94();
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> result = test94.new Solution().inorderTraversal(treeNode);
        System.out.println(result);

    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            inorder(root, res);
            return res;
        }

        public void inorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }
    }

    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            Deque<TreeNode> stk = new LinkedList<TreeNode>();
            while (root != null || !stk.isEmpty()) {
                while (root != null) {
                    stk.push(root);
                    root = root.left;
                }
                root = stk.pop();
                res.add(root.val);
                root = root.right;
            }
            return res;
        }
    }

    class Solution3 {
        //其实整个过程我们就多做一步：
        // 假设当前遍历到的节点为 x，将 x 的左子树中最右边的节点的右孩子指向 x，
        // 这样在左子树遍历完成后我们通过这个指向走回了 x，
        // 且能通过这个指向知晓我们已经遍历完成了左子树，而不用再通过栈来维护，省去了栈的空间复杂度。

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            TreeNode predecessor = null;

            while (root != null) {
                if (root.left != null) {
                    // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                    predecessor = root.left;
                    while (predecessor.right != null && predecessor.right != root) {
                        predecessor = predecessor.right;
                    }

                    // 让 predecessor 的右指针指向 root，继续遍历左子树
                    if (predecessor.right == null) {
                        predecessor.right = root;
                        root = root.left;
                    }
                    // 说明左子树已经访问完了，我们需要断开链接
                    else {
                        res.add(root.val);
                        predecessor.right = null;
                        root = root.right;
                    }
                }
                // 如果没有左孩子，则直接访问右孩子
                else {
                    res.add(root.val);
                    root = root.right;
                }
            }
            return res;
        }
    }



}
