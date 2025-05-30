package cn.leetcode;

import java.util.*;

public class Test49 {
    //49. 字母异位词分组
    /**给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     字母异位词:是由重新排列源单词的所有字母得到的一个新单词。
     示例 1:
     输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     示例 2:
     输入: strs = [""]
     输出: [[""]]
     示例 3:
     输入: strs = ["a"]
     输出: [["a"]]
     提示：
     1 <= strs.length <= 104
     0 <= strs[i].length <= 100
     strs[i] 仅包含小写字母
     *
     */

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Test49 test49 = new Test49();
        List<List<String>> list = test49.groupAnagrams2(strs);
        System.out.println(list);

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            // 将排序后的字符串作为哈希表的键 getOrDefault()方法 获取键对应的值，如果键不存在，则返回默认值 默认值为空列表
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                    System.out.println(sb.toString());
                    System.out.println(sb);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
