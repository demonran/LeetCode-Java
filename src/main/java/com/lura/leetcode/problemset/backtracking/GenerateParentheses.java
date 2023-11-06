package com.lura.leetcode.problemset.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * @ description: GenerateParentheses
 * @ author: Liu Ran
 * @ data: 6/25/23 16:30
 */
public class GenerateParentheses {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, n, new StringBuilder());
        return ans;
    }

    private void backtrack(int left, int right, StringBuilder sb) {
        if (left < 0 || right < 0) {
            return;
        }

        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            ans.add(sb.toString());
            return;
        }

        sb.append('(');
        backtrack(left - 1, right, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        backtrack(left, right - 1, sb);
        sb.deleteCharAt(sb.length() - 1);

    }
}
