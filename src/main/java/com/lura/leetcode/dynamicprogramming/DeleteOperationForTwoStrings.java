package com.lura.leetcode.dynamicprogramming;

/**
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * 每步 可以删除任意一个字符串中的一个字符。
 *
 * @ description: EleteOperationForTwoStrings
 * @ author: Liu Ran
 * @ data: 4/25/23 17:03
 */
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int lcs = lcs(word1, word2);
        return word1.length() - lcs + word2.length() - lcs;
    }

    private int lcs(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j +1] = dp[i][j] + 1;
                }else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
