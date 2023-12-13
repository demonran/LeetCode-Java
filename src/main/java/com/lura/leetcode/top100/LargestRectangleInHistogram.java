package com.lura.leetcode.top100;

/**
 * LargestRectangleInHistogram
 *
 * @author Liu Ran
 */
public class LargestRectangleInHistogram {

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
}
