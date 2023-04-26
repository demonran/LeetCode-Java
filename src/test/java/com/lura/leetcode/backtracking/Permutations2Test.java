package com.lura.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ description: Permutations2Test
 * @ author: Liu Ran
 * @ data: 4/26/23 17:06
 */
class Permutations2Test {

    private final Permutations2 solution = new Permutations2();

    @Test
    void permuteUnique() {
        List<List<Integer>> lists = solution.permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);
    }
}
