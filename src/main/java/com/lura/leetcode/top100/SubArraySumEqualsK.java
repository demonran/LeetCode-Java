package com.lura.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * SubArraySumEqualsK
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * @author Liu Ran
 */
public class SubArraySumEqualsK {

    /**
     * 枚举解法，把数组的每个值都当作子数组的第一个元素进行遍历。
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            // 每一个元素都作为子数据的第一个元素进行枚举
            for (int j = i; j < nums.length; j++) {
                sum += nums[j]; // 每增加一个元素， 就重新就算值。
                if (sum == k) { // 判断新的和是否等于k
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * 枚举法，每一个元素作为子数组的最后一个元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumV2(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            // 每一个元素都作为子数据的最后一个元素进行枚举
            for (int j = i; j >= 0; j--) {
                sum += nums[j]; // 每增加一个元素， 就重新就算值。
                if (sum == k) { // 判断新的和是否等于k
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * 哈希表 + 前缀和
     * [j..i] 表示j到i的子数据
     * pre[i]表示前i项和 pre[0..j]
     * 那么 pre[j..i] = pre[0..i] - pre[0..j-1]
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumV3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        int cnt = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            // 存在前sum[0..j] + k = sum[0..i]
            if (map.containsKey(pre - k)) {
                cnt += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return cnt;
    }
}
