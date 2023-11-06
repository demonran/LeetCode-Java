package com.lura.leetcode.problemset.string;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 * @ description: FirstUniqueCharacterInAString
 * @ author: Liu Ran
 * @ data: 5/31/23 14:45
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
