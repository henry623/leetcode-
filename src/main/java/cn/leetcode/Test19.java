package cn.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Test19 {
    //19. 删除链表的倒数第 N 个结点

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 示例 1：
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     * 提示：
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     * 进阶：你能尝试使用一趟扫描实现吗？
     */

    public static void main(String[] args) {

        Test19 test19 = new Test19();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNodeNew = test19.removeNthFromEnd4(listNode, 1);
        while (listNodeNew != null) {
            System.out.println(listNodeNew.val);
            listNodeNew = listNodeNew.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        //因为节点全是地址值，所以返回的ans是dummy.next 这也是引入cur的原因
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    //娱乐写法
    public ListNode removeNthFromEnd4(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        ListNode she = new ListNode(-1);
        ListNode rem = she;
        ListNode you = head;
        boolean flag = false;

        while(you != null){
            if(!flag){
                ListNode love = you;
                for (int i = 0; i < n;i ++ ){
                    love = love.next;
                }
                if(love == null ){
                    flag = true;
                    she.next = you.next; // 在n == 1时 需要将最后的指针指向null  非n==1时这个赋值与下一个赋值时相同会被覆盖
                    you = you.next;

                    continue;
                }
            }

            she.next = you;
            she = she.next;
            you = you.next;
        }
        return rem.next;
    }


}
