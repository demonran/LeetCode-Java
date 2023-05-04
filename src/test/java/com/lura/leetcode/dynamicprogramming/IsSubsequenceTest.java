package com.lura.leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ description: IsSubsequenceTest
 * @ author: Liu Ran
 * @ data: 4/25/23 20:35
 */
class IsSubsequenceTest {

    private IsSubsequence solution = new IsSubsequence();
    @Test
    void isSubsequence() {
        boolean actual = solution.isSubsequence("abc", "ahbgdc");
        assertTrue(actual);
    }
}
