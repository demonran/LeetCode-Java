package com.lura.leetcode.problemset.backtracking;

import com.lura.leetcode.problemset.backtracking.Subsets;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @ description: SubsetsTest
 * @ author: Liu Ran
 * @ data: 4/26/23 15:15
 */
class SubsetsTest {

    private final Subsets solution = new Subsets();

    @Test
    void subsets() {
        List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }

    @Test
    void subsets_2() {
        List<List<Integer>> subsets = solution.subsets(new int[]{10, 1, 2, 7, 6, 1, 5});
        System.out.println(subsets);
    }


}
