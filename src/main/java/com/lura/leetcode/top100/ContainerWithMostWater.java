package com.lura.leetcode.top100;

/**
 * ContainerWithMostWater
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * @author Liu Ran
 */
public class ContainerWithMostWater {

    /**
     * 双指针，分别从两边向中间靠近
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            // 哪边短就移动哪边， 因为area = min(left, right) * (right - left), 如果移动大的， min(left, right) 一定不会变大。
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;

    }
}
