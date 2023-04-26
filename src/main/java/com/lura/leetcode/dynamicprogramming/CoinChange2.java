package com.lura.leetcode.dynamicprogramming;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 518. 零钱兑换 II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 *
 * @ description: CoinChange2
 * @ author: Liu Ran
 * @ data: 4/26/23 09:24
 */
public class CoinChange2 {

    /**
     * 动态规划 自上而下
     * 选择使用硬币， 总金额减少
     * 不实用硬币， 硬币数量减少
     */
    int res = 0;

    public int change(int amount, int[] coins) {
        return ways(amount, 0, coins);
    }

    private int ways(int amount, int i, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        // 金额<0 或者 硬币用完
        if (amount < 0 || i == coins.length) {
            return 0;
        }
        //不使用硬币
        int p1 = ways(amount, i + 1, coins);
        //使用硬币
        int p2 = ways(amount - coins[i], i, coins);
        return p1 + p2;
    }


    /**
     * 动态规划： 自底向上
     * i 表示金额， j表示前0..j个硬币 ， dp[i][j] 表示方法数
     * 不使用硬币： dp[i][j] = dp[i-1][j]
     * 使用硬币： dp[i][j] = dp[i-1][j]  + dp[i - coins[j]][j]
     */
    public int changeV2(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < amount + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i - coins[j - 1] >= 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - coins[j - 1]][j];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }

            }

        }
        return dp[amount][n];

    }

    public int changeV3(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0]= 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }

}
