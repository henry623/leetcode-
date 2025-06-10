public class AtomicIntegerAddition {
    //private static AtomicInteger num = new AtomicInteger(0);
    private static int num2 = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                //num.incrementAndGet();
                num2++;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                //num.incrementAndGet();
                num2++;
            }
        });

        thread1.start();
        thread2.start();

        /*try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        while (thread1.isAlive() || thread2.isAlive()) {
            // do nothing

        }

        //System.out.println("Final value: " + num.get());
        System.out.println("Final value: " + num2);
    }
}
