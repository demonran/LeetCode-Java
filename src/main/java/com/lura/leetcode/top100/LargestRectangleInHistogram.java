package com.lura.leetcode.top100;

import java.util.Arrays;
import java.util.Stack;

/**
 * LargestRectangleInHistogram
 *
 * @author Liu Ran
 */
public class LargestRectangleInHistogram {

    /**
     * 方法一： 定位左边界，计算每个右边界的面积
     */
    public int largestRectangleArea(int[] heights) {

        int res = 0;
        // 枚举左边界
        for (int left = 0; left < heights.length; left++) {
            int minHeight = Integer.MAX_VALUE;
            // 枚举有边界
            for (int right = left; right < heights.length; right++) {
                // 计算最小高度
                minHeight = Math.min(heights[right], minHeight);
                // 计算最大面积
                res = Math.max(res, (right - left + 1) * minHeight);
            }
        }
        return res;
    }

    /**
     * 方法二： 当前高度作为高，向左右扩展，计算每个块的面积
     */
    public int largestRectangleAreaV2(int[] heights) {

        int res = 0;
        // 枚举左边界
        for (int mid = 0; mid < heights.length; mid++) {
            int left = mid - 1;
            int right = mid + 1;
            // 向左移动
            while (left >= 0 && heights[left] >= heights[mid]) {
                left--;
            }
            // 向右移动
            while (right < heights.length && heights[right] >= heights[mid]) {
                right++;
            }
            res = Math.max(res, (right - left - 1) * heights[mid]);
        }
        return res;
    }


    /**
     * 方法三： 单调栈， 分别计算每个heights[i]的左右边界， 即第一个不高于heights[i]的位置。
     */
    public int largestRectangleAreaV3(int[] heights) {

        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();
        // 找到以heights[i]为min height的左边界
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        // 找到以heights[i]为min height的右边界， 需要从右往左遍历
        for (int i = n - 1; i >=0 ; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        // 计算面积
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }


    /**
     * 方法四： 单调栈，常数优化，
     * 找左边界的时候同时找到右编辑
     * 找i的左边界时i入栈， 让i出栈的i0即为i的右边界， 因为heights[i0]是第一个小于heights[i]的。
     * 虽然找不到正确的右边界（因为右边界有相等的情况没有找到最右边的那个），但是当计算最右边的那个的左边界时会找到最左边界，所以计算结果是对的。
     */
    public int largestRectangleAreaV4(int[] heights) {

        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(right, n);
        Stack<Integer> stack = new Stack<>();
        // 找到以heights[i]为min height的左边界
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.pop()] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        // 还没有出栈的元素，右边界设置为n, 因为他们右边没有比他们小的元素
        while (!stack.isEmpty()) {
            right[stack.pop()] = n;
        }
        // 计算面积
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }

}
