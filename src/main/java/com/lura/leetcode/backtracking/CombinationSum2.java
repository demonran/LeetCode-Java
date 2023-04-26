package com.lura.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 *
 * @ description: CombinationSum
 * @ author: Liu Ran
 * @ data: 4/26/23 15:38
 */
public class CombinationSum2 {

    private final List<List<Integer>> res = new ArrayList<>();

    /**
     * 元素可重复，不可复选
     * 1. 先排序
     * 2. 剪枝： 和前一个相同就跳过
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, 0, new LinkedList<>());
        return res;
    }

    private void backtrack(int[] nums, int start, int target, int sum, LinkedList<Integer> track) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            //防止重复选中
            if (i > start && num == nums[i - 1]) {
                continue;
            }

            track.addLast(num);
            sum += num;
            backtrack(nums, i + 1, target, sum, track);

            track.removeLast();
            sum -= num;

        }
    }


}
