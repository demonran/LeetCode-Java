package com.lura.leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * FindAllAnagramsInAString
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 * @author Liu Ran
 */
public class FindAllAnagramsInAString {
    /**
     * 滑动窗口，使用map存储数据
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (Objects.equals(need.get(c), window.get(c))) {
                valid++;
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= p.length()) {
                // 判断是否满足条件
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (Objects.equals(need.get(d), window.get(d))) {
                    valid--;
                }
                window.put(d, window.get(d) - 1);
            }


        }
        return res;
    }

    /**
     * 保持p.length固定长度的窗口， 比较窗口中的内容是否相同，
     * 通过把字符串转换成int[]数据，排除顺序干扰。
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagramsV2(String s, String p) {
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }

        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + p.length()) - 'a']++;

            if (Arrays.equals(sCount, pCount)) {
                res.add(i+ 1);
            }
        }

        return res;
    }
}
