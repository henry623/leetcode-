package Test;

public class fanruan1 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindromeSubseq("bbbab"));
    }


    static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param s string字符串 提供的字符串
         * @return int整型
         */
        public int longestPalindromeSubseq (String s) {
            // write code here
            int n = s.length();
            int[][] dp = new int[n][n];

            for(int i = 0;i<n;i++){
                dp[i][i] = 1;
            }
            for(int i=n-2;i>=0;i--){
                for(int j =i+1;j<n;j++){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }else{
                        dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
            }

            return dp[0][n-1];
        }
    }
}
