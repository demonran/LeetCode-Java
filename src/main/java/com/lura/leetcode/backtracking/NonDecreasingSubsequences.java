package com.lura.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 491. 递增子序列
 *给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 * @ description: NonDecreasingSubsequences
 * @ author: Liu Ran
 * @ data: 4/26/23 15:24
 */
public class NonDecreasingSubsequences {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0, new LinkedList<>());
        return res;
    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> track) {

        if (track.size() >= 2) {
            res.add(new LinkedList<>(track));
        }
        // 用哈希集合防止重复选择相同元素
        HashSet<Integer> used = new HashSet<>();

        for (int i = start; i < nums.length; i++) {
            if (!track.isEmpty() && nums[i] < track.getLast()) {
                continue;
            }
            if (used.contains(nums[i])) {
                continue;
            }

            //选择
            track.addLast(nums[i]);
            used.add(nums[i]);
            // 递归
            backtrack(nums, i + 1, track);
            // 回退
            track.removeLast();
        }
    }

}
