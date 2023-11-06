package com.lura.leetcode.problemset.string;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 *
 * @ description: ValidAnagram
 * @ author: Liu Ran
 * @ data: 5/28/23 23:02
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] c1 = encode(s);
        int[] c2 = encode(t);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] encode(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }

    public boolean isAnagramV2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int j : count) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }
}
