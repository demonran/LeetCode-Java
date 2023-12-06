package com.lura.leetcode.top100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ValidParentheses
 *
 * @author Liu Ran
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();

        for (char c : s.toCharArray()) {
            // 如果是左括号，直接push到left栈中
            if (c == '(' || c == '[' || c == '{') {
                left.push(c);
            } else { // 如果是右括号
                // 如果左括号为空， 右括号对应的左括号不是左括号， 则直接返回falsie
                if (left.isEmpty() || leftOf(c) != left.pop()) {
                    return false;
                }
            }
        }
        return left.isEmpty(); // 左括号是否使用完
    }

    private char leftOf(char c) {
        if (c == ')') return '(';
        else if (c == '}') return '{';
        else return '[';
    }
}
