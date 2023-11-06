package com.lura.leetcode.problemset.string;

/**
 * 28. 找出字符串中第一个匹配项的下标
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果needle 不是 haystack 的一部分，则返回 -1 。
 *
 * @ description: FindTheIndexOfTheFirstOccurrenceInAString
 * @ author: Liu Ran
 * @ data: 6/26/23 16:58
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {

    /**
     * 暴力解法
     */
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }
}
