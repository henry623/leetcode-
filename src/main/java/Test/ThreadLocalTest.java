package Test;

import com.google.common.collect.Lists;

import java.util.List;


public class ThreadLocalTest {
    private List<String> messages = Lists.newArrayList();

    //holder 是一个 ThreadLocal<ThreadLocalTest> 类型的静态变量，
    //即每个线程都会拥有自己的 ThreadLocalTest 实例。
    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);
    //和上面的代码作用相同
    private static final ThreadLocal<ThreadLocalTest> holder2 = new ThreadLocal<ThreadLocalTest>() {
        @Override
        protected ThreadLocalTest initialValue() {
            return new ThreadLocalTest();
        }
    };

    public static void add(String message) {
        /*holder.get()：获取当前线程所绑定的那个 ThreadLocalTest 实例。
        holder.get().messages：访问该实例的 messages 成员变量（它是一个 List<String>）。
        .add(message)：将传入的 message 字符串添加进这个列表。*/
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();

        System.out.println("size: " + holder.get().messages.size());//0
        return messages;
    }

    public static void main(String[] args) {
        ThreadLocalTest.add("一枝花算不算浪漫");
        System.out.println(holder.get().messages);
        System.out.println("size: " + holder.get().messages.size());//1
        ThreadLocalTest.clear();
    }
}

