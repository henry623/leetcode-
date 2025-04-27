import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        int numberOfThreads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            System.out.println("Thread " + i + " started");
            new Thread(() -> {
                System.out.println("Thread started");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread finished");
                countDownLatch.countDown();
            }).start();
        }

        try {
            System.out.println("Waiting for threads to finish...");
            countDownLatch.await();
            System.out.println("All threads finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
