package com.lura.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @ description: LetterCombinationsOfAPhoneNumber
 * @ author: Liu Ran
 * @ data: 6/21/23 15:11
 */
public class LetterCombinationsOfAPhoneNumber {

    String[] map = {"abc", "def", "ghi", "gkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return ans;
        }
        // 从 digits[0] 开始进行回溯
        backtrack(digits, 0, new StringBuilder());
        return ans;
    }

    void backtrack(String digits, int start, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        for (int i = start; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '2';
            for (char c : map[digit].toCharArray()) {
                sb.append(c);
                backtrack(digits, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }

        }
    }
}
