package com.lura.leetcode.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GroupAnagrams
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * @author Liu Ran
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            String encode = encode(str);
            List<String> list = map.getOrDefault(encode, new ArrayList<>());
            list.add(str);
            map.put(encode, list);
        }
        return map.values().stream().toList();
    }

    /**
     * 编码
     * abc 11100000000000000000000000
     * abb 12000000000000000000000000
     * bab 12000000000000000000000000
     * @param str
     * @return
     */
    private String encode(String str) {
        char[] chars = new char[26];
        for (char c : str.toCharArray()) {
            int delta = c - 'a';
            chars[delta]++;
        }
        return new String(chars);
    }

    /**
     * 编码
     * abc a1b1c2
     * abb a1b2
     * bab a1b2
     * @param str
     * @return
     */
    private String encodeV2(String str) {
        int[] chars = new int[26];
        for (char c : str.toCharArray()) {
            int delta = c - 'a';
            chars[delta]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0) {
                sb.append((char)( i + 'a')).append(chars[i]);
            }
        }
        return sb.toString();
    }
}
