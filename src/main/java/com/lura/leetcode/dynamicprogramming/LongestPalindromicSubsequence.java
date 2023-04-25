package com.lura.leetcode.dynamicprogramming;

/**
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列
 *
 * @ description: LongestPalindromicSubsequence
 * @ author: Liu Ran
 * @ data: 4/25/23 14:19
 */
public class LongestPalindromicSubsequence {

    // s[i] = s[j] =>dp[i][j] = dp[i+1] + dp[j-1] + 2
    // s[i] != s[j] => dp[i][j] = max(dp[i+1][j], dpj[i][j-1]
    public int longestPalindromeSubseq(String s) {

        int n = s.length();

        int[][] dp = new int[n][n];
        //一个字母时长度为1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }



}
