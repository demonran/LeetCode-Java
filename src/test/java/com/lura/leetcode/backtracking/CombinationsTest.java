package com.lura.leetcode.backtracking;

import com.lura.leetcode.problemset.backtracking.Combinations;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @ description: CombinationsTest
 * @ author: Liu Ran
 * @ data: 4/26/23 15:04
 */
class CombinationsTest {

    private final Combinations solution = new Combinations();

    @Test
    void combine() {
        int n = 4, k = 2;
        List<List<Integer>> combine = solution.combine(n, k);
        System.out.println(combine);
    }
}
