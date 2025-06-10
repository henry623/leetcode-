package cn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test131 {
    //131. 分割回文串

    /**
     * 给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     * 示例 1：
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     * 示例 2：
     * 输入：s = "a"
     * 输出：[["a"]]
     * 提示：
     * 1 <= s.length <= 16
     * s 仅由小写英文字母组成
     */

    public static void main(String[] args) {
        Test131 test131 = new Test131();
        List<List<String>> lists = test131.new Solution().partition("aab");
        for (List<String> list : lists) {
            System.out.println(list);
        }

    }

    class Solution {
        boolean[][] f;
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> ans = new ArrayList<String>();
        int n;

        public List<List<String>> partition(String s) {
            n = s.length();
            f = new boolean[n][n];
            for (int i = 0; i < n; ++i) {
                Arrays.fill(f[i], true);
            }

            for (int i = n - 1; i >= 0; --i) {
                for (int j = i + 1; j < n; ++j) {
                    // f[i][j] 表示 s[i..j] 是否是回文串
                    f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
                }
            }

            dfs(s, 0);
            return ret;
        }

        public void dfs(String s, int i) {
            if (i == n) {
                ret.add(new ArrayList<String>(ans));
                return;
            }
            // 只取i=j右边的 避免重复
            for (int j = i; j < n; ++j) {
                if (f[i][j]) {
                    ans.add(s.substring(i, j + 1));
                    dfs(s, j + 1);
                    ans.remove(ans.size() - 1);
                }
            }
        }
    }

    class Solution2 {
        int[][] f;
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> ans = new ArrayList<String>();
        int n;

        public List<List<String>> partition(String s) {
            n = s.length();
            f = new int[n][n];

            dfs(s, 0);
            return ret;
        }

        public void dfs(String s, int i) {
            if (i == n) {
                ret.add(new ArrayList<String>(ans));
                return;
            }
            for (int j = i; j < n; ++j) {
                if (isPalindrome(s, i, j) == 1) {
                    ans.add(s.substring(i, j + 1));
                    dfs(s, j + 1);
                    ans.remove(ans.size() - 1);
                }
            }
        }

        // 记忆化搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
        public int isPalindrome(String s, int i, int j) {
            if (f[i][j] != 0) {
                return f[i][j];
            }
            if (i >= j) {
                f[i][j] = 1;
            } else if (s.charAt(i) == s.charAt(j)) {
                f[i][j] = isPalindrome(s, i + 1, j - 1);
            } else {
                f[i][j] = -1;
            }
            return f[i][j];
        }
    }

}
