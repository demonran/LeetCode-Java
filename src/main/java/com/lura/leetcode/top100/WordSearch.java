package com.lura.leetcode.top100;

/**
 * WordSearch
 *
 * @author Liu Ran
 */
public class WordSearch {

    boolean found = false;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 每个位置作为开头字符进行匹配
                backtrack(board, i, j, word, 0, new boolean[m][n]);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param board 二维网格
     * @param i 横坐标
     * @param j 纵坐标
     * @param word 目标单词
     * @param p  匹配的字符个数
     * @param visited 标记
     */
    private void backtrack(char[][] board, int i, int j, String word, int p, boolean[][] visited) {
        // 匹配的字符个数 == 单词个数，则匹配成功
        if (p == word.length()) {
            found = true;
            return;
        }
        // 越界后直接退出
        if (i < 0 || i >= board.length) {
            return;
        }
        if (j < 0 || j >= board[0].length) {
            return;
        }
        // 走过的位置，直接跳过
        if (visited[i][j]) {
            return;
        }
        // 如果单词不匹配直接退出
        if (word.charAt(p) != board[i][j]) {
            return;
        }


        visited[i][j] = true;
        backtrack(board, i + 1, j, word, p + 1, visited);
        backtrack(board, i, j + 1, word, p + 1, visited);
        backtrack(board, i - 1, j, word, p + 1, visited);
        backtrack(board, i, j - 1, word, p + 1, visited);
        visited[i][j] = false;
    }


}
