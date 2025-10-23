package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class huawei1 {
    static class Magic{
        int a,b;
        Magic(int a,int b){
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
//            String[] nm = in.next().split(" ");
//            int n = Integer.parseInt(nm[0]);
//            int m = Integer.parseInt(nm[1]);
            int n = in.nextInt();
            int m = in.nextInt();
            List<Magic> magics = new ArrayList<>();
            for (int i = 0; i < n; i++) {
//                String[] ab = in.next().split(" ");
//                int a = Integer.parseInt(ab[0]);
//                int b = Integer.parseInt(ab[1]);
                int a = in.nextInt();
                int b = in.nextInt();
                magics.add(new Magic(a,b));
            }
            //Collections.sort(magics,(m1,m2) ->(m1.a-m1.b) - (m2.a-m2.b));
            Collections.sort(magics,(m1,m2) ->{
                int diff1 = m1.b -m1.a;
                int diff2 = m2.b -m2.a;
                if(diff1 >=0 && diff2 <0){
                    return -1;
                } else if (diff1 <0 && diff2>=0) {
                    return 1;
                } else if (diff1>=0 && diff2>=0) {
                    return Integer.compare(m1.a,m2.a);
                }else{
                    return Integer.compare(m2.b,m1.b);
                }
            });
            long cur = m;
            boolean success = true;
            for (Magic magic : magics) {
                if(cur <= magic.a){
                    success = false;
                    break;
                }
                cur += magic.b - magic.a;
            }
            System.out.println(success ? "Yes" : "No");
        }

    }
}
