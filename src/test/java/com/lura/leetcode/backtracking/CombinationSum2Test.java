package com.lura.leetcode.backtracking;

import com.lura.leetcode.problemset.backtracking.CombinationSum2;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @ description: CombinationSum2Test
 * @ author: Liu Ran
 * @ data: 4/26/23 16:06
 */
class CombinationSum2Test {

    private CombinationSum2 solution = new CombinationSum2();

    @Test
    void combinationSum2() {
        List<List<Integer>> lists = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
    }
}
