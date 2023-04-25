package com.lura.leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ description: CoinChangeTest
 * @ author: Liu Ran
 * @ data: 4/25/23 13:05
 */
class CoinChangeTest {

    private final CoinChange coinChange = new CoinChange();


    @Test
    void coinChangeV2() {
        int[] coins = {2};
        int actual = coinChange.coinChangeV2(coins, 3);
        assertEquals(-1, actual);
    }

    @Test
    void coinChange() {
        int[] coins = {2};
        int actual = coinChange.coinChange(coins, 3);
        assertEquals(-1, actual);
    }

    @Test
    void coinChangeV3() {
        int[] coins = {2};
        int actual = coinChange.coinChangeV3(coins, 3);
        assertEquals(-1, actual);
    }
}
