package com.lura.leetcode.longestmountain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ description: SolutionTest
 * @ author: Liu Ran
 * @ data: 4/23/23 15:10
 */
class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void longestMountain() {
        int[] arr = {2,1,4,7,3,2,5};
        int actual = solution.longestMountain(arr);
        assertEquals(5, actual);
    }

    @Test
    void longestMountainV2() {
        int[] arr = {2,1,4,7,3,2,5};
        int actual = solution.longestMountainV2(arr);
        assertEquals(5, actual);
    }
}
