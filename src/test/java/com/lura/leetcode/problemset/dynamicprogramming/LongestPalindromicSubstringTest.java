package com.lura.leetcode.problemset.dynamicprogramming;

import com.lura.leetcode.problemset.dynamicprogramming.LongestPalindromicSubstring;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ description: LongestPalindromicSubstringTest
 * @ author: Liu Ran
 * @ data: 4/25/23 16:24
 */
class LongestPalindromicSubstringTest {

    private final LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
    @Test
    void longestPalindrome() {
        String actual = solution.longestPalindrome("babad");
        assertEquals("aba", actual);
    }
}
