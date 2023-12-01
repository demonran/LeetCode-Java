package com.lura.leetcode.top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * CombinationSum
 *
 * @author Liu Ran
 */
public class CombinationSum {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> track = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, int sum) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 选择
            track.add(candidates[i]);
            sum += candidates[i];
            // 进入下一层, 可重复选择，所以不是i+1 而是i.
            backtrack(candidates, target, i, sum);
            // 回退选择
            track.remove(track.size() - 1);
            sum -= candidates[i];
        }
    }
}
