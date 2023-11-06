package com.lura.leetcode.backtracking;

import com.lura.leetcode.problemset.backtracking.Permutations;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @ description: PermutationsTest
 * @ author: Liu Ran
 * @ data: 4/26/23 14:48
 */
class PermutationsTest {

    private Permutations solution = new Permutations();

    @Test
    void permute() {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);

    }
}
