package com.lura.leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 */

public class PalindromePartitioning {

    List<List<String>> res = new ArrayList<>();
    List<String> track = new LinkedList<>();
    boolean[][] f;

    public List<List<String>> partition(String s) {
        int n = s.length();
        f = new boolean[n][n];

        // 初始化所有的子串都是回文
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        // 计算所有回文子串
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
            }
        }

        backtrack(s, 0);
        return res;

    }

    private void backtrack(String s, int start) {
        if (start == s.length()) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i < s.length(); i++) {

            if (f[start][i]) { // 是回文
                // 添加
                track.add(s.substring(start, i + 1));
                // 进入下一个子串判断
                backtrack(s, i + 1);
                // 回退
                track.remove(track.size() - 1);
            }
        }
    }

}
