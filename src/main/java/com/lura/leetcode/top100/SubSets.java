package com.lura.leetcode.top100;

import java.util.LinkedList;
import java.util.List;

/**
 * SubSets
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * @author Liu Ran
 */
public class SubSets {

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, new LinkedList<>(), 0);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> track, int start) {
        res.add(new LinkedList<>(track));
        // 不走回头路
        for (int i = start; i < nums.length; i++) {
            // 选择
            track.add(nums[i]);
            // 进入下一层, i + 1 从后面的元素开始进行遍历
            backtrack(nums, track, i + 1);
            // 取消选择
            track.remove(track.size() - 1);
        }
    }
}
