package com.lura.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
}
