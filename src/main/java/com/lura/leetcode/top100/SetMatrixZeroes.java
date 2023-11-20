package com.lura.leetcode.top100;

/**
 * SetMatrixZeroes
 * ### 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * @author Liu Ran
 */
public class SetMatrixZeroes {

    /**
     * 额外的空间标记
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // 标记对应的row和col
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // row或者col被标记，该元素都为0。
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 使用第一行和第一列进行标记
     * [[1,1,1],
     * [1,0,1],
     * [1,1,1]]
     * <p>
     * 用matrix[1,0] 和matrix[0,1]标记，
     *
     * @param matrix
     */
    public void setZeroesV2(int[][] matrix) {
        boolean rowFlag = false, colFlag = false;
        // 标记col是否有0
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
            }
        }
        // 标记row是否有0
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
            }
        }
        // 如果中间元素有0，标记第一行和第一列
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 根据第一行和第一列的标记，设置当前元素
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 如果列标记为true，则设置第一列所有元素为0
        if (colFlag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        // 如果行标记为true，则设置第一行所有元素为0
        if (rowFlag) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }


    }

    /**
     * 使用第一行和第一列进行标记
     * [[1,1,1],
     * [1,0,1],
     * [1,1,1]]
     * <p>
     * 用matrix[1,0] 和matrix[0,1]标记，
     *
     * @param matrix
     */
    public void setZeroesV3(int[][] matrix) {
        boolean colFlag = false;
        // 标记col是否有0
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
            }

            for (int j = 1; j < matrix[0].length; j++) {
                // 如果中间元素有0，标记第一行和第一列
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 第一行要最后更新
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            // 如果列标记为true，则设置第一列所有元素为0
            if (colFlag) {
                matrix[i][0] = 0;
            }
        }
    }
}
