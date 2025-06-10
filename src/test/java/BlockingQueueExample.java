import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {
    private static final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);
    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer thread started");
                queue.put(1);
                System.out.println("Producer thread ended");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                System.out.println("Consumer thread started");
                Integer item = queue.take();
                System.out.println("Consumer thread ended" + item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        consumer.start();
        producer.start();

    }
}
