package com.lura.leetcode.top100;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * MinimumWindowSubstring
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * @author Liu Ran
 */
public class MinimumWindowSubstring {
    /**
     * 滑动窗口
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE, start = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 必须要用equals
                if (Objects.equals(need.get(c), window.get(c))) {
                    valid++;
                }
            }
            // 右移左指针，缩小窗口
            while (valid == need.size()) {
                // 记录当前匹配后的子串的start和len
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }

                char d = s.charAt(left);
                if (need.containsKey(d)) {
                    // 找到了影响valid的字符，就减少valid
                    if (Objects.equals(need.get(d), window.get(d))) {
                        valid--;
                    }
                    // 窗口中去掉当前字符
                    window.put(d, window.get(d) - 1);
                }
                left++;
            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);

    }
}
