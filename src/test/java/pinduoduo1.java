import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class pinduoduo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            in.nextLine();
            String[] arr = in.nextLine().split(" ");
            int maxLen = 1;
            int cur = 1;
            for (int i = 1; i < n; i++) {
                if (compare(arr[i - 1], arr[i])) {
                    cur++;
                    maxLen = Math.max(maxLen, cur);
                } else {
                    cur = 1;
                }
            }
            System.out.println(maxLen);
        }
    }

    private static boolean compare(String a, String b) {
        if (a.length() < b.length()) {
            return true;
        } else if (a.length() == b.length()) {
            return a.compareTo(b) <= 0;
        } else {
            return false;
        }
    }
}