package com.lura.leetcode.backtracking;

import com.lura.leetcode.problemset.backtracking.NonDecreasingSubsequences;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @ description: NonDecreasingSubsequencesTest
 * @ author: Liu Ran
 * @ data: 4/26/23 15:30
 */
class NonDecreasingSubsequencesTest {

    private final NonDecreasingSubsequences solution = new NonDecreasingSubsequences();

    @Test
    void findSubsequences() {
        List<List<Integer>> subsequences = solution.findSubsequences(new int[]{4, 6, 7, 7});
        System.out.println(subsequences);
    }
}
