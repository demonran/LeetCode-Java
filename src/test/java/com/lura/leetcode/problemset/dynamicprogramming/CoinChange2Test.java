package com.lura.leetcode.problemset.dynamicprogramming;

import com.lura.leetcode.problemset.dynamicprogramming.CoinChange2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ description: CoinChange2Test
 * @ author: Liu Ran
 * @ data: 4/26/23 09:35
 */
class CoinChange2Test {

    private final CoinChange2 solution = new CoinChange2();
    @Test
    void change() {
        int amount = 5;
        int[] coins = {1, 2, 5};

        int actual = solution.change(amount, coins);
        assertEquals(4, actual);

    }

    @Test
    void changeV2() {
        int amount = 5;
        int[] coins = {1, 2, 5};

        int actual = solution.changeV2(amount, coins);
        assertEquals(4, actual);

    }

    @Test
    void changeV3() {
        int amount = 5;
        int[] coins = {1, 2, 5};

        int actual = solution.changeV3(amount, coins);
        assertEquals(4, actual);

    }
}
