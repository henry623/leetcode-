package cn.leetcode;

import java.util.Stack;

public class Test114 {
    //114. 二叉树展开为链表

    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，
     * 而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     * 示例 1：
     * 输入：root = [1,2,5,3,4,null,6]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6]
     * 示例 2：
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     * 输入：root = [0]
     * 输出：[0]
     * 提示：
     * 树中结点数在范围 [0, 2000] 内
     * -100 <= Node.val <= 100
     * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
     */

    public static void main(String[] args) {
        Test114 test = new Test114();
//                 1
//                / \
//               2   5
//              / \   \
//             3   4   6
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null,
                new TreeNode(6)));
        test.flatten4(root);
        test.PrintBinaryTreeMidRecur(root);
        //test.PrintBinaryTreeBacRecur(root);
        //test.PrintBinaryTreeForRecur(root);

    }

    public void flatten(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }

    public void flatten2(TreeNode root) {
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {
                toVisit.push(cur); // 添加根节点
                cur = cur.right; // 递归添加右节点
            }
            cur = toVisit.peek(); // 已经访问到最右的节点了
            // 在不存在左节点或者右节点已经访问过的情况下，访问根节点
            if (cur.left == null || cur.left == pre) {
                toVisit.pop();
                /**************修改的地方***************/
                cur.right = pre;
                cur.left = null;
                /*************************************/
                pre = cur;
                cur = null;
            } else {
                cur = cur.left; // 左节点还没有访问过就先访问左节点
            }
        }
    }

    public void flatten3(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode pre = null;
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            /***********修改的地方*************/
            if (pre != null) {
                pre.right = temp;
                pre.left = null;
            }
            /********************************/
            if (temp.right != null) {
                s.push(temp.right);
            }
            if (temp.left != null) {
                s.push(temp.left);
            }
            /***********修改的地方*************/
            pre = temp;
            /********************************/
        }
    }

    private TreeNode pre = null;//如果在内部类中加private

    public void flatten4(TreeNode root) {
        if (root == null)
            return;
        flatten4(root.right);
        flatten4(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }


    public void flatten5(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }


    //后序遍历
    public void PrintBinaryTreeBacRecur(TreeNode root) {
        if (root == null)
            return;

        PrintBinaryTreeBacRecur(root.left);
        PrintBinaryTreeBacRecur(root.right);

        System.out.print(root.val + " ");

    }

    //前序遍历
    public void PrintBinaryTreeForRecur(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        PrintBinaryTreeForRecur(root.left);
        PrintBinaryTreeForRecur(root.right);
    }

    //中序遍历
    public void PrintBinaryTreeMidRecur(TreeNode root) {
        if (root == null)
            return;
        PrintBinaryTreeMidRecur(root.left);
        System.out.print(root.val + " ");
        PrintBinaryTreeMidRecur(root.right);
    }


}
