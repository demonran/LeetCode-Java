package com.lura.leetcode.problemset.string;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * @ description: ReverseWordsInAString3
 * @ author: Liu Ran
 * @ data: 6/9/23 13:14
 */
public class ReverseWordsInAString3 {
    /**
     * 创建一个新字符串
     * 双指针找单词
     * 反转
     */
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        int start = 0, end;
        while (start < n) {
            while (start < n && s.charAt(start) == ' ') {
                ans.append(s.charAt(start));
                start++;
            }
            end = start;
            while (end < n && s.charAt(end) != ' ') {
                end++;
            }
            for (int i = end - 1; i >= start; i--) {
                ans.append(s.charAt(i));
            }
            start = end;
        }
        return ans.toString();
    }

    /**
     * 不开辟新的空间
     */
    public String reverseWordsV2(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0, end;
        while (start < n) {
            while (start < n && s.charAt(start) == ' ') {
                start++;
            }
            end = start;
            while (end < n && s.charAt(end) != ' ') {
                end++;
            }
            int left = start, right = end - 1;
            while (left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
            start = end;
        }
        return new String(chars);
    }

}
