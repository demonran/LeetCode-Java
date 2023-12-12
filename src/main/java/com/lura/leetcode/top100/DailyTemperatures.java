package com.lura.leetcode.top100;

import java.util.Stack;

/**
 * DailyTemperatures
 *
 * @author Liu Ran
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        //存储最大值索引
        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            // 将stack中的值和当前值进行比较，如果比当前值小，就移除。相当于把两个最高的值之间的移除。
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            //把当前值放入栈，
            stack.push(i);
        }
        return res;
    }
}
