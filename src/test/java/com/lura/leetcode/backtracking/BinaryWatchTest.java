package com.lura.leetcode.backtracking;

import com.lura.leetcode.problemset.backtracking.BinaryWatch;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @ description: BinaryWatchTest
 * @ author: Liu Ran
 * @ data: 4/26/23 14:23
 */
class BinaryWatchTest {

    private BinaryWatch solution = new BinaryWatch();

    @Test
    void readBinaryWatch() {
        List<String> strings = solution.readBinaryWatch(1);
        System.out.println(strings);
    }
}
