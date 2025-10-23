package Test;

public class shopee1 {
    public static void main(String[] args) {
        System.out.println(new shopee1().new Solution().buildHouses(1));
    }

    public class Solution {
        /**
         * Note: 类名、方法名、参数名已经指定，请勿修改
         *
         * @param n int整型
         * @return int整型
         */
        public int buildHouses(int n) {
            // write code here
            if (n == 0) return 0;
            boolean[] colUsed = new boolean[n];
            boolean[] diag1 = new boolean[2 * n - 1];
            boolean[] diag2 = new boolean[2 * n - 1];
            int[] count = new int[1];
            backTrack(0, n, colUsed, diag1, diag2, count);
            return count[0];
        }

        public void backTrack(int row, int n, boolean[] colUsed, boolean[] diag1, boolean[] diag2, int[] count) {
            if (row == n) {
                count[0]++;
                return;
            }
            for (int col = 0; col < n; col++) {
                int d1 = row - col + n - 1;
                int d2 = row + col;
                if (!colUsed[col] && !diag1[d1] && !diag2[d2]) {
                    colUsed[col] = true;
                    diag1[d1] = true;
                    diag2[d2] = true;

                    backTrack(row + 1, n, colUsed, diag1, diag2, count);
                    colUsed[col] = false;
                    diag1[d1] = false;
                    diag2[d2] = false;

                }
            }

        }
    }
}
