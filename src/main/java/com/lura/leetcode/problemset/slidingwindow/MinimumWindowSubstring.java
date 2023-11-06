package com.lura.leetcode.problemset.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * @ description: MinimumWindowSubstring
 * @ author: Liu Ran
 * @ data: 4/28/23 15:25
 */
public class MinimumWindowSubstring {


    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0; //满足要求的字符

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 判断是否需要
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (Objects.equals(need.get(c), window.get(c))) {
                    valid++;
                }
            }

            while (need.size() == valid) {

                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (Objects.equals(window.get(d), need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }


            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
