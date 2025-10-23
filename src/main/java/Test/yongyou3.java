package Test;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class yongyou3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();
        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = in.nextInt();
        }
        if (target == 0) {
            System.out.println(0);
            return;
        }
        int dp0 = 0;
        int dp1 = money[0];
        for (int i = 1; i < n; i++) {
            int newDP0 = Math.max(dp0, dp1);
            int newDP1 = dp0 + money[i];
            dp0 = newDP0;
            dp1 = newDP1;
        }
        int maxTotal = Math.max(dp0, dp1);
        if (maxTotal < target) {
            System.out.println(-1);
            return;
        }
        int[] prevDP0 = new int[n + 1];
        int[] prevDP1 = new int[n + 1];
        Arrays.fill(prevDP0, -1);
        Arrays.fill(prevDP1, -1);
        prevDP0[0] = 0;
        prevDP1[1] = money[0];

        for (int i = 1; i < n; i++) {
            int[] curDP0 = new int[n + 1];
            int[] curDP1 = new int[n + 1];
            Arrays.fill(curDP0, -1);
            Arrays.fill(curDP1, -1);
            for (int j = 0; j <= n; j++) {
                int maxVal = -1;
                if (prevDP0[j] != -1) {
                    maxVal = Math.max(maxVal, prevDP0[j]);
                }
                if (prevDP1[j] != -1) {
                    maxVal = Math.max(maxVal, prevDP1[j]);
                }
                if (maxVal != -1) {
                    curDP0[j] = maxVal;
                }
            }
            for (int j = 1; j <= n; j++) {
                if (prevDP0[j - 1] != -1) {
                    int newVal = prevDP0[j - 1] + money[i];
                    if (curDP1[j] < newVal) {
                        curDP1[j] = newVal;
                    }
                }
            }

            prevDP0 = curDP0;
            prevDP1 = curDP1;

        }
        int ans = n + 1;
        for (int j = 1; j <= n; j++) {
            int total = Math.max(prevDP0[j], prevDP1[j]);
            if (total >= target) {
                ans = Math.min(ans, j);
            }
        }


        System.out.println(ans);
    }
}