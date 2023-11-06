package com.lura.leetcode.problemset.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 *给你一个 无重复元素 的整数数组candidates 和一个目标整数target,找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。
 * 你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个
 *
 * @ description: CombinationSum
 * @ author: Liu Ran
 * @ data: 4/26/23 15:38
 */
public class CombinationSum {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backtrack(candidates, 0, target, 0, new LinkedList<>());
        return res;
    }

    private void backtrack(int[] nums, int start, int target, int sum,  LinkedList<Integer> track) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];

            track.addLast(num);
            sum += num;
            // 可以重复使用数字， 所以i不用加1
            backtrack(nums, i , target, sum, track);

            track.removeLast();
            sum -= num;

        }
    }


}
