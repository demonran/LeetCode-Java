package com.lura.leetcode.top100;

/**
 * TrappingRainWater
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * @author Liu Ran
 */
public class TrappingRainWater {

    /**
     * 暴力解法， 计算每一个竖格可以装的水量
     * water[i] = min(max[0..i], max[i..end] - height[i]
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int l_max = 0;
            // 找max[0..i]
            for (int j = 0; j <= i; j++) {
                l_max = Math.max(l_max, height[j]);
            }
            int r_max = 0;
            // 找max(i..end)
            for (int j = i; j < height.length; j++) {
                r_max = Math.max(r_max, height[j]);
            }
            // Math.min(l_max, r_max) < height[i]  说明装不了水，直接为0。
            res += Math.min(l_max, r_max) - height[i];
        }
        return res;
    }

    /**
     * 备忘录方法，记录l_max和r_max， 计算每一个竖格可以装的水量
     * water[i] = min(max(0..i), max(i..end) - height[i]
     *
     * @param height
     * @return
     */
    public int trapV2(int[] height) {
        int res = 0;
        int n = height.length;
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        l_max[0] = height[0];
        // 找max(0..i) 记录在l_max[i]中
        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(l_max[i - 1], height[i]);
        }
        r_max[n - 1] = height[n-1];
        // 找max(i..end) 记录在r_max[i]中
        for (int i = n - 2; i > 0; i--) {
            r_max[i] = Math.max(r_max[i + 1], height[i]);
        }
        for (int i = 0; i < n; i++) {

            // Math.min(l_max, r_max) < height[i]  说明装不了水，直接为0。
            res +=  Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }

    /**
     * 双指针
     * water[i] = min(max(0..i), max(i..end) - height[i]
     *
     * @param height
     * @return
     */
    public int trapV3(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        int l_max = 0; // max(0..left)
        int r_max = 0; // max(right..end)
        while (left < right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            if (l_max < r_max) {
                res += l_max - height[left];
                left++;
            }else {
                res += r_max - height[right];
                right--;
            }

        }
        return res;
    }
}
