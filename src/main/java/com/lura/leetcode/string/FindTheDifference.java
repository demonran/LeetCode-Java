package com.lura.leetcode.string;

/**
 * 389. 找不同
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 */
public class FindTheDifference {

    /**
     * 计数法
     */
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            if (--cnt[c - 'a'] < 0) {
                return c;
            }
        }
        return 0;

    }

    /**
     * 求和法
     *
     */
    public char findTheDifferenceV2(String s, String t) {
        int ret = 0;

        for (char c : t.toCharArray()) {
            ret += c;
        }

        for (char c : s.toCharArray()) {
            ret -= c;
        }

        return (char) ret;

    }

    /**
     * 位运算， 两个字符串合并起来，单数的那个就是想到得到的值
     */
    public char findTheDifferenceV3(String s, String t) {
        int ret = 0;

        for (char c : t.toCharArray()) {
            ret ^= c;
        }

        for (char c : s.toCharArray()) {
            ret ^= c;
        }

        return (char) ret;

    }
}
