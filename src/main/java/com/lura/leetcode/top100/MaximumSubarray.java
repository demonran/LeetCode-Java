package com.lura.leetcode.top100;

/**
 * MaximumSubarray
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * @author Liu Ran
 */
public class MaximumSubarray {

    /**
     * 动态规划， dp[i] = max(dp[i - 1] + nums[i], nums[i])
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        // base case
        dp[0] = nums[0]; // 第一个元素的子数组就是本身。
        for (int i = 1; i < nums.length; i++) {
            //状态转移方程， 计算每个dp[i]的值
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        // 获取最大的dp[i];
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (res < dp[i]) {
                res = dp[i];
            }
        }
        return res;
    }

    /**
     * 压缩， 动态规划， dp[i] = max(dp[i - 1] + nums[i], nums[i])
     * dp[i]只和dp[i-1]， 即前一个数有关，所以空间负责度可以压缩为O(1)
     * @param nums
     * @return
     */
    public int maxSubArrayV2(int[] nums) {
        int pre = nums[0];  // 第一个元素的子数组就是本身。
        int res = pre;
        for (int i = 1; i < nums.length; i++) {
            //状态转移方程， 计算当前子数组的和
            pre = Math.max(pre + nums[i], nums[i]);
            // 直接计算最大值res
            res = Math.max(pre, res);
        }
        return res;
    }


}
