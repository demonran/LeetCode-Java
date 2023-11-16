package com.lura.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * LongestSubstringWithoutRepeatCharacters
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * @author Liu Ran
 */
public class LongestSubstringWithoutRepeatCharacters {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int res = 0;
        // 记录窗口中的字符个数
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            // 如果窗口中的字符大于1则需要收缩。
            while (map.get(c) > 1) { // 直到缩减到重复字符
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;

    }
}
