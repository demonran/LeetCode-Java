package com.lura.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * GenerateParentheses
 *
 * @author Liu Ran
 */
public class GenerateParentheses {

    List<String> res = new ArrayList<>();
    StringBuilder track = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtrack(n, n);
        return res;
    }

    private void backtrack(int left, int right) {
        // 剩余左括号 > 剩余右括号，说明右括号多， 不符合
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }
        // 添加左括号
        track.append('(');
        backtrack(left - 1, right);
        track.deleteCharAt(track.length() - 1);
        // 添加右括号
        track.append(')');
        backtrack(left, right - 1);
        track.deleteCharAt(track.length() - 1);
    }
}
