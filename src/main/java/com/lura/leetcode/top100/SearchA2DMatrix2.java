package com.lura.leetcode.top100;

/**
 * SearchA2DMatrix2
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * @author Liu Ran
 */
public class SearchA2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        // 从右上角开始查找
        while (i < matrix.length && j >= 0) {
            // 找到了直接返回
            if (matrix[i][j] == target) {
                return true;
            }
            // 如果大于target， 则往左找
            if (matrix[i][j] > target) {
                j--;
            } else { // 如果小于target， 则往下找
                i++;
            }
        }
        return false;
    }
}
