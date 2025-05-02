package cn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test22 {
    //22. 括号生成

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 示例 1：
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     * 输入：n = 1
     * 输出：["()"]
     * 提示：
     * 1 <= n <= 8
     */

    public static void main(String[] args) {
        Test22 test22 = new Test22();
        System.out.println(test22.new Solution().generateParenthesis(3));


    }

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> combinations = new ArrayList<String>();
            generateAll(new char[2 * n], 0, combinations);
            return combinations;
        }

        public void generateAll(char[] current, int pos, List<String> result) {
            if (pos == current.length) {
                if (valid(current)) {
                    result.add(new String(current));
                }
            } else {
                //等于 for(int i = 1;i <lenth.chars['(',')'];i++){
                //current[pos] = chars[i];
                //generateAll(current, pos + 1, result);
                //回溯
                //current[pos] = null;
                //}
                current[pos] = '(';
                generateAll(current, pos + 1, result);
                current[pos] = ')';
                generateAll(current, pos + 1, result);
            }
        }

        public boolean valid(char[] current) {
            int balance = 0;
            for (char c: current) {
                if (c == '(') {
                    ++balance;
                } else {
                    --balance;
                }
                if (balance < 0) {
                    return false;
                }
            }
            return balance == 0;
        }
    }

    class Solution2 {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<String>();
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }
            if (open < max) {
                cur.append('(');
                backtrack(ans, cur, open + 1, close, max);
                //回溯 上一行代码的情况已经遍历完毕
                cur.deleteCharAt(cur.length() - 1);
            }
            if (close < open) {
                cur.append(')');
                backtrack(ans, cur, open, close + 1, max);
                //回溯 上一行代码的情况已经遍历完毕
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }

    class Solution3 {
        ArrayList[] cache = new ArrayList[100];

        public List<String> generate(int n) {
            if (cache[n] != null) {
                return cache[n];
            }
            ArrayList<String> ans = new ArrayList<String>();
            if (n == 0) {
                ans.add("");
            } else {
                for (int c = 0; c < n; ++c) {
                    for (String left: generate(c)) {
                        for (String right: generate(n - 1 - c)) {
                            ans.add("(" + left + ")" + right);
                        }
                    }
                }
            }
            cache[n] = ans;
            return ans;
        }

        public List<String> generateParenthesis(int n) {
            return generate(n);
        }
    }

}
