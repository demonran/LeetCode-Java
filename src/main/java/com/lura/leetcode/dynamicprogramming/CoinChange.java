package com.lura.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * @ description: CoinChange
 * @ author: Liu Ran
 * @ data: 4/25/23 11:13
 */
public class CoinChange {

    int[] mem;

    public int coinChange(int[] coins, int amount) {
        mem = new int[amount + 1];
        return dp(coins, amount);

    }

    private int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        if (mem[amount] != 0) {
            return mem[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {

            int nextChange = dp(coins, amount - coin);
            if (nextChange == -1) {
                continue;
            }
            res = Math.min(res, nextChange + 1);
        }
        mem[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return mem[amount];
    }

    public int coinChangeV2(int[] coins, int amount) {

        int[] dp = new int[amount  +1];
        Arrays.fill(dp, amount + 1); // 不能用最大值， 会出现精度问题，导致后面的min方法取错值
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }

        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    int coinChangeV3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }


}
