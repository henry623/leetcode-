import java.math.BigDecimal;

public class addTest {
    public static void main(String[] args) {
        add(1, 2);
        add(1.1, 2.2);
        add(1, 2.2);
        add(1.1, 2);
    }

    //写一个泛型方法 返回值为泛型 输入输出也为泛型 可以解决任意类型相加的问题
    public static <T extends Number>  double  add3(T a, T b) {
        System.out.println(a.doubleValue() + b.doubleValue());
        return a.doubleValue() + b.doubleValue();

    }

    private static <T extends Number> Number add(T t1, T t2) {
        System.out.println(t1.doubleValue() + t2.doubleValue());
        return t1.doubleValue() + t2.doubleValue();
    }

    private static <T extends Number> BigDecimal add2(T t1, T t2) {
        BigDecimal bd1 = new BigDecimal(t1.toString());
        BigDecimal bd2 = new BigDecimal(t2.toString());
        return bd1.add(bd2);
    }
}
