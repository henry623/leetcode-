public class ForTest {
    public static void main(String[] args) {
        int a = 5;

        int b = a++;
        int c = ++a;
        System.out.println(b);
        System.out.println(c);

        int i = 10;
        Integer integer = new Integer(i);
        String string = integer.toString(integer);
        System.out.println(string);


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
