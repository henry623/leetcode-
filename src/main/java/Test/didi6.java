package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class didi6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0){
            int n = in.nextInt();
            int[] childrenCount = new int[n+1];
            for(int i = 2; i <= n; i++){
                int p = in.nextInt();
                childrenCount[p]++;
            }
            List<Integer> list = new ArrayList<>();
            list.add(0);
            for(int i = 1; i <= n; i++){
                if(childrenCount[i]>0){
                    list.add(childrenCount[i] -1);
                }
            }
            Collections.sort(list, Collections.reverseOrder());
            int ans =0;
            for(int i = 0; i < list.size(); i++){
                ans = Math.max(ans, list.get(i) + i +1);
            }
            System.out.println(ans);

        }
    }

}
