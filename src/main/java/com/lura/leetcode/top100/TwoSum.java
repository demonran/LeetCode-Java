package com.lura.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum
 *  1. 两数之和
 *  给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * @author Liu Ran
 */
public class TwoSum {

    /**
     * 穷举法, 时间复杂度O(n2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * hash表辅助， 时间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumV2(int[] nums, int target) {
        // 先使用hash表记录 v -> i的值， 然后通过target -nums[i] 查找v对应的i.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            // 避免出现同一个数相加等于target的情况
            if (j != null && i != j) {
                return new int[]{i, j};
            }
        }
        return null;
    }

    /**
     * hash表的另一种简化方式，一次遍历
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumV3(int[] nums, int target) {
        // 先使用hash表记录 v -> i的值， 然后通过target -nums[i] 查找v对应的i.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            // 避免出现同一个数相加等于target的情况
            if (j != null) {
                return new int[]{i, j};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
