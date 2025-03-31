package cn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test438 {
    //438. 找到字符串中所有字母异位词

    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。
     * 不考虑答案输出的顺序。
     * 示例 1:
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     *  示例 2:
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     * 提示:
     * 1 <= s.length, p.length <= 3 * 104
     * s 和 p 仅包含小写字母
     */

    public static void main(String[] args) {
        Test438 test438 = new Test438();
        List<Integer> anagrams = test438.findAnagrams2("cbaebabacd", "abc");
        System.out.println(anagrams);
//        for (Integer integer : anagrams) {
//            System.out.println(integer);
//        }

    }

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
            if (count[s.charAt(i) - 'a'] == 1) {
                --differ;
            }
            // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
            else if (count[s.charAt(i) - 'a'] == 0) {
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
            if (count[s.charAt(i + pLen) - 'a'] == -1) {
                --differ;
            }
            // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
            else if (count[s.charAt(i + pLen) - 'a'] == 0) {
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }


}
