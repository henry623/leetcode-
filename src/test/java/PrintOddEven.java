public class PrintOddEven {
    private static int count = 0;
    private static final int max_Value = 100;
    private static final Object lock = new Object();
    public static void main(String[] args) {
        Runnable printOdd = () -> {
            while (count < max_Value) {
                synchronized (lock) {
                    if (count % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Odd: " + count);
                    count++;
                    lock.notify();
                }
            }
        };
        Runnable printEven = () -> {
            while (count < max_Value) {
                synchronized (lock) {
                    if (count % 2 == 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Even: " + count);
                    count++;
                    lock.notify();
                }
            }
        };

        Thread thread1 = new Thread(printOdd, "Odd");
        Thread thread2 = new Thread(printEven, "Even");
        thread1.start();
        thread2.start();

    }
}
