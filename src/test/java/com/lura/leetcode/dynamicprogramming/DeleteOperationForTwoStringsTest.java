package com.lura.leetcode.dynamicprogramming;

import com.lura.leetcode.problemset.dynamicprogramming.DeleteOperationForTwoStrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ description: DeleteOperationForTwoStringsTest
 * @ author: Liu Ran
 * @ data: 4/25/23 17:28
 */
class DeleteOperationForTwoStringsTest {

    private final DeleteOperationForTwoStrings solution = new DeleteOperationForTwoStrings();

    @Test
    void minDistance() {
        int actual = solution.minDistance("sea", "eat");
        assertEquals(2, actual);
    }
}
