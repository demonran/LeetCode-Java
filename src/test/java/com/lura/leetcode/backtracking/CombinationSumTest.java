package com.lura.leetcode.backtracking;

import com.lura.leetcode.problemset.backtracking.CombinationSum;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @ description: CombinationSumTest
 * @ author: Liu Ran
 * @ data: 4/26/23 15:50
 */
class CombinationSumTest {

    private final CombinationSum solution = new CombinationSum();

    @Test
    void combinationSum() {
        List<List<Integer>> lists = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }
}
