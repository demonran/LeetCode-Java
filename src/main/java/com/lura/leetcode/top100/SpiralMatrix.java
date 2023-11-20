package com.lura.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * SpiralMatrix
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * @author Liu Ran
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        while (true) {
            // 向右移动
            for (int i = l; i <= r; i++) res.add(matrix[t][i]);
            if (++t > b) break; // 向下移动一格，判断是否跳出循环
            // 向下移动
            for (int i = t; i <= b; i++) res.add(matrix[i][r]);
            if (--r < l) break; // 向左移动一格，判断是否跳出循环
            // 向左移动
            for (int i = r; i >= l; i--) res.add(matrix[b][i]);
            if (--b < t) break; // 向上移动一格，判断是否跳出循环
            // 向上移动
            for (int i = b; i >= t; i--) res.add(matrix[i][l]);
            if (++l > r) break; // 向右移动一格，判断是否跳出循环
        }
        return res;

    }
}
