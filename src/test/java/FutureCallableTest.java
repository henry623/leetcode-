import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallableTest {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();

        Callable<Integer> callable = () -> {
            System.out.println(Thread.currentThread().getName() + "callable start");
            Thread.sleep(1000);
            return 100;
        };

        Future<Integer> future = exec.submit(callable);
        System.out.println("主线程执行其他任务");

        try {
            System.out.println("future.get() = " + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        exec.shutdown();
    }
}
