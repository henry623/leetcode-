import java.util.Scanner;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // 读取数组长度n
            int n = scanner.nextInt();

            // 读取数组元素
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLong();
            }

            // 计算最少操作次数
            int result = minOperations(arr, n);

            // 输出结果
            System.out.println(result);

            scanner.close();
        }

        public static int minOperations(long[] arr, int n) {
            // 当所有非空子数组的平均值相同时，数组必须是等差数列
            // 检查是否已经是等差数列
            if (n <= 2) {
                return 0; // 长度为1或2的数组总是等差数列
            }

            // 计算可能的公差
            long d = (arr[n-1] - arr[0]) / (n-1);

            // 如果不能整除，则不可能形成等差数列，必须移除至少n-2个元素
            if ((arr[n-1] - arr[0]) % (n-1) != 0) {
                return n - 2;
            }

            // 检查是否为等差数列，记录不符合的元素数量
            int count = 0;
            for (int i = 0; i < n; i++) {
                long expected = arr[0] + i * d;
                if (arr[i] != expected) {
                    count++;
                }
            }

            // 如果已经是等差数列，返回0；否则，移除非等差数列的元素
            return Math.min(count, n - 2);
        }
    }
