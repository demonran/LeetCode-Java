package com.lura.leetcode.top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LetterCombinationsOfAPhoneNumber
 *
 * @author Liu Ran
 */
public class LetterCombinationsOfAPhoneNumber {

    List<String> res = new ArrayList<>();
    StringBuilder track = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        // 字母数组和按钮对应
        String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, letters, 0);
        return res;
    }

    private void backtrack(String digits, String[] letters, int start) {
        if (track.length() == digits.length()) {
            res.add(track.toString());
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            String letter = letters[digits.charAt(i) - '0'];
            for (char c : letter.toCharArray()) {
                // 选择
                track.append(c);
                // 进入下一层
                backtrack(digits, letters, i + 1);
                // 回退选择
                track.deleteCharAt(track.length() - 1);
            }
        }
    }
}
