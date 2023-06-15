package com.lura.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @ description: LongestSubstringWithoutRepeatingCharacters
 * @ author: Liu Ran
 * @ data: 6/15/23 12:33
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int ans = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断是否要收缩
            while (window.get(c) > 1) {
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

}
