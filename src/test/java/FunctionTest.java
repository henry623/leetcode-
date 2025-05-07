import java.util.function.Consumer;
public class FunctionTest {



    public void doSomething() {
        Consumer<String> consumer = this::printMessage; // 使用this::printMessage引用本类方法
        consumer.accept("Hello, world!");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        FunctionTest obj = new FunctionTest();
        obj.doSomething();
    }


}
