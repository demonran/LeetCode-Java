package com.lura.leetcode.problemset.dynamicprogramming;

import com.lura.leetcode.problemset.dynamicprogramming.LongestCommonSubsequence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ description: LongestCommonSubsequenceTest
 * @ author: Liu Ran
 * @ data: 4/25/23 17:17
 */
class LongestCommonSubsequenceTest {

    private final LongestCommonSubsequence solution = new LongestCommonSubsequence();
    @Test
    void longestCommonSubsequence() {
        int actual = solution.longestCommonSubsequence("abcde", "ace");
        assertEquals(3, actual);
    }
}
