import java.util.ArrayList;
import java.util.List;

public class ForTest {
    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        Integer[] B = new Integer[]{};

        List<Integer> c = new ArrayList<>();

//        int a = 5;
//
//        int b = a++;
//        int c = ++a;
//        System.out.println(b);
//        System.out.println(c);
//
//        int i = 10;
//        Integer integer = new Integer(i);
//        String string = integer.toString(integer);
//        System.out.println(string);

//        int a = 9;
//        //System.out.println(a);
//        int b = a++;
//        System.out.println(b);//9
//        int c = ++a;
//        System.out.println(c);//11
//        int d = c--;
//        System.out.println(d);//11
//        int e = --d;
//        System.out.println(e);//10
//        System.out.println(a);//11

        int x = 5;
        int z = 12/x;
        System.out.println(z);
        int y = x++; // 先将 x 的当前值赋给 y（y 变为 5），然后将 x 加 1（x 变为 6）
        System.out.println("x: " + x); // 输出 6
        System.out.println("y: " + y); // 输出 5

//
////            b++;
//            System.out.println(i);
////            System.out.println(b);
//        }
//        for (int i = 0; i < a; ++i) {
//            System.out.println(i);
////            ++c;
////            System.out.println(c);
        }

}
