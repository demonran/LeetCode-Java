package com.lura.leetcode.problemset.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * @ description: Subsets
 * @ author: Liu Ran
 * @ data: 4/26/23 15:11
 */
public class Subsets {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0 , new LinkedList<>());
        return res;
    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        //添加路径数组到结果数组中
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);
            backtrack(nums, i + 1, track);
            track.removeLast();
        }

    }
}
