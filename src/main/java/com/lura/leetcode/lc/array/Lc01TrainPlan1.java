package com.lura.leetcode.lc.array;

/**
 * 训练计划 I
 * 教练使用整数数组 actions 记录一系列核心肌群训练项目编号。为增强训练趣味性，需要将所有奇数编号训练项目调整至偶数编号训练项目之前。请将调整后的训练项目编号以 数组 形式返回。
 *
 * @author Liu Ran
 */
public class Lc01TrainPlan1 {

    /**
     * 双指针思路
     * @param actions
     * @return
     */
    public int[] trainingPlan(int[] actions) {
        // 定义双指针
        int i = 0, j = actions.length - 1;
        while (i < j) {
            // 找到第一个偶数
            while (i < j && actions[i] % 2 == 1) i++;
            // 找到第一个奇数
            while (i < j && actions[j] % 2 == 0) j--;
            // 交换位置
            int tmp = actions[i];
            actions[i] = actions[j];
            actions[j] = tmp;
            i++;
            j--;
        }
        return actions;
    }
}
