import java.util.Deque;
import java.util.LinkedList;

public class StackTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        System.out.println(list.pollLast()); // 输出 2

        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        System.out.println(deque.pop()); // 输出 2

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        System.out.println(list1.pollLast()); // 输出 2

        /**
         * 1. Deque.push(E e)
         * 来源：push() 是 Deque 接口提供的方法。
         * 功能：将元素压入双端队列的头部（作为栈顶元素）。
         * 异常行为：如果队列已满（在有容量限制的情况下），会抛出 IllegalStateException。
         * 等价方法：push() 等价于 addFirst(E e)。
         * 2. Deque.add(E e)
         * 来源：add() 是 Deque 接口继承自 Queue 接口的方法。
         * 功能：将元素插入到双端队列的尾部。
         * 异常行为：如果队列已满（在有容量限制的情况下），会抛出 IllegalStateException。
         * 等价方法：add() 等价于 addLast(E e)。
         */
        Deque<Integer> deque1 = new LinkedList<>();
        deque1.push(1);
        deque1.push(2);
        System.out.println(deque1.pop()); // 输出 2


    }
}
