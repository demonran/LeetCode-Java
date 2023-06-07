package com.lura.leetcode.dynamicprogramming;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * @ description: LongestPalindromicSubstring
 * @ author: Liu Ran
 * @ data: 4/25/23 15:46
 */
public class LongestPalindromicSubstring {

    /**
     * 回文有两种， 以i为中心， 以i和i+1为中心都算回文
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // s[i]为中心
            String s1 = palindrome(s, i, i);
            // s[i]和s[i+1] 为中心
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
