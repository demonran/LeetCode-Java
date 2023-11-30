package com.lura.leetcode.top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Permutations
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @author Liu Ran
 */
public class Permutations {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new LinkedList<>(), new boolean[nums.length]);
        return res;
    }

    /**
     * 回溯算法
     * 用track list记录添加的元素
     * 用used[]标记是否被添加
     */
    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) { // 已经使用过了,跳过
                continue;
            }
            // 选择该元素
            track.addLast(nums[i]);
            used[i] = true;
            // 进入下一层
            backtrack(nums, track, used);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }
}
