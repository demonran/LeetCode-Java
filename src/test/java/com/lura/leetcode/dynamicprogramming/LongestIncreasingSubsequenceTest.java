package com.lura.leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ description: LongestIncreasingSubsequenceTest
 * @ author: Liu Ran
 * @ data: 4/25/23 20:18
 */
class LongestIncreasingSubsequenceTest {

    private final LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
    @Test
    void lengthOfLIS() {
        int[] nums = {10,9,2,5,3,7,101,18};
        int actual = solution.lengthOfLIS(nums);
        assertEquals(4, actual);
    }
}
