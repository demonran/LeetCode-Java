package com.lura.leetcode.problemset.dynamicprogramming;

/**
 * 516. 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列
 *
 * @ description: LongestPalindromicSubsequence
 * @ author: Liu Ran
 * @ data: 4/25/23 14:19
 */
public class LongestPalindromicSubsequence {

    // s[i] == s[j] =>dp[i][j] = dp[i+1] + dp[j-1] + 2
    // s[i] != s[j] => dp[i][j] = max(dp[i+1][j], dpj[i][j-1])
    public int longestPalindromeSubseq(String s) {

        int n = s.length();

        int[][] dp = new int[n][n];
        //每一个字母都可以作为一个回文序列， 长度为1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // 双指针 i, j ， i 往左移动， j往右移动
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 如果两个字符相等，直接+2
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 如果不想等，则取缩减左边或者缩减右边的最大值
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }



}
