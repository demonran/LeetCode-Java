package com.lura.leetcode.top100;

import java.util.Stack;

/**
 * MinStack
 *
 * @author Liu Ran
 */
public class MinStack {
    // 记录所有元素
    private final Stack<Integer> stack;
    // 记录最小元素
    private final Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        // 如果当前元素小于栈顶元素，则插入最小栈
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        Integer val = stack.pop();
        // 如果取出的元素是最小元素，则移除最小栈
        if (val.equals(getMin())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
