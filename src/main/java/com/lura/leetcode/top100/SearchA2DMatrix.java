package com.lura.leetcode.top100;

/**
 * SearchA2DMatrix
 *
 * @author Liu Ran
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 先找行,
        int left = 0, right = matrix.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        // target比第一个元素都小，直接返回false
        if (left == 0) {
            return false;
        }
        // 找到第一个首元素的前一行
        int row = left - 1;
        // 在当前行进行二分查找
        left = 0 ;
        right = matrix[row].length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return false;

    }

    /**
     * 把二维数组拍平成1维数组， 长度为 m * n
     */
    public boolean searchMatrixV2(int[][] matrix, int target) {
       int m = matrix.length;
       int n = matrix[0].length;

       int left = 0 , right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 把mid转换成二维数组mid /n 即为行， mid % n 即为列
            if (matrix[mid / n][mid % n] == target) {
                return true;
            }else if( matrix[mid / n][mid % n] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return false;
    }
}
