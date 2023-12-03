package com.lura.leetcode.top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 初始化表盘
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }
        backtrack(board, 0);
        return res;
    }

    private void backtrack(List<String> board, int row) {
        if (row == board.size()) {
            res.add(new LinkedList<>(board));
            return;
        }

        int n = board.get(row).length();

        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {// 校验通过，进行选择
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());
                // 进入下一层
                backtrack(board, row + 1);
                // 撤销选择
                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }
    }

    private boolean isValid(List<String> board, int row, int col) {
        int n = board.size();
        // col列是否有Q
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // 右上角是否有Q
        for (int i = row - 1, j = col + 1; i >= 0 && j < n;  i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // 左上角是否有Q
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
