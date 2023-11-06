package com.lura.leetcode.problemset.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * @ description: Permutations
 * @ author: Liu Ran
 * @ data: 4/26/23 14:41
 */
public class Permutations {

    private final List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new LinkedList<>());
        return res;
    }

    //回溯方法
    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            //要创建新的List,复制出来之前的值
            res.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.addLast(num);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}
