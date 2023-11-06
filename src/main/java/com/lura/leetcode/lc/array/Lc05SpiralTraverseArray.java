package com.lura.leetcode.lc.array;

/**
 * Lc05SpiralTraverseArray
 *螺旋遍历二维数组
 * 给定一个二维数组 array，请返回「螺旋遍历」该数组的结果。
 *
 * 螺旋遍历：从左上角开始，按照 向右、向下、向左、向上 的顺序 依次 提取元素，然后再进入内部一层重复相同的步骤，直到提取完所有元素。
 *
 * @author Liu Ran
 */
public class Lc05SpiralTraverseArray {
    public int[] spiralArray(int[][] array) {

        if (array.length == 0) {
            return new int[0];
        }
        // 定义四个边界(左右上下) l r t b
        int l = 0, t = 0, r = array[0].length - 1, b = array.length - 1;
        int[] arr = new int[(r + 1) * (b + 1)];
        int index = 0;
        while (true) {
            // 往右遍历，增加顶部边界
            for (int i = l; i <= r; i++) arr[index++] = array[t][i];
            if (++t > b) break;
            // 往下遍历， 减少右边界
            for (int i = t; i <= b; i++) arr[index++] = array[i][r];
            if (--r < l) break;
            // 往左遍历， 增加下边界
            for (int i = r; i >= l; i--) arr[index++] = array[b][i];
            if (--b < t) break;
            //往上遍历，增加左边界
            for (int i = b; i >= t; i--) arr[index++] = array[i][l];
            if (++l > r) break;

        }
        return arr;
    }

}
