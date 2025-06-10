public class ThreadLocalDemo {
    private static final ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "default");

    public static void main(String[] args) {
        // 线程A：设置值
        threadLocal.set("Data from Thread-A");
        String dataFromA = threadLocal.get(); // 显式获取值

        // 线程B：通过参数接收值并设置到自己的ThreadLocal
        Thread threadB = new Thread(() -> {
            threadLocal.set(dataFromA); // 设置来自线程A的值
            String dataFromB = threadLocal.get();
            System.out.println("Thread-B: " + threadLocal.get());
            Thread threadC = new Thread(() -> {
                threadLocal.set(dataFromB);
                System.out.println("Thread-C: " + threadLocal.get());
            });
            threadC.start();
            threadLocal.remove(); // 清理防止内存泄漏
        });

        threadB.start();
    }
}
