import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Bishi3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String s = in.next();
        int[] maxEnd = new int[N];
        Arrays.fill(maxEnd, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int start = stack.peek() + 1;
                    if (maxEnd[start] < i) {
                        maxEnd[start] = i;
                    }
                }
            }
        }
        int count = 0;
        int i = 0;
        while (i < N) {
            if (maxEnd[i] != -1) {
                count++;
                i = maxEnd[i] + 1;
            } else {
                count++;
                i++;
            }
        }
        System.out.println(count);


    }
}