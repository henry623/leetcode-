package Test;

import java.util.*;

public class huawei2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] groups = new int[N];
        long total = 0;
        int maxGroup = 0;
        for (int i = 0; i < N; i++) {
            groups[i] = in.nextInt();
            total += groups[i];
            maxGroup = Math.max(maxGroup, groups[i]);
        }

        if(M==N){
            System.out.println(maxGroup);
            return;
        }

        if(M==1){
            System.out.println(total);
            return;
        }
        long left = maxGroup;
        long right = total;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if(canDivide(groups,mid,M)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(left);

    }

    private static boolean canDivide(int[] groups, long maxCapacity, int m) {
        int count = 1;
        long cur = 0;
        for (int group : groups) {
            if (cur + group > maxCapacity) {
                count++;
                cur = group;
                if(count>m){
                    return false;
                }
            } else {
                cur += group;
            }
        }
        return true;
    }
}
