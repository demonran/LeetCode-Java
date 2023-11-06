package com.lura.leetcode.problemset.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * @ description: Combinations
 * @ author: Liu Ran
 * @ data: 4/26/23 15:00
 */
public class Combinations {


    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 && n <= 0) {
            return res;
        }
        backtrack(n, k, 1, new LinkedList<>());
        return res;
    }

    private void backtrack(int n, int k, int start, LinkedList<Integer> track) {
        if (k == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (track.contains(i)) {
                continue;
            }
            track.addLast(i);
            backtrack(n, k, i + 1, track);
            track.removeLast();
        }
    }

}
