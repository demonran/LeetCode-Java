package com.lura.leetcode.problemset.string;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * @ description: LengthOfLastWord
 * @ author: Liu Ran
 * @ data: 5/22/23 10:39
 */
public class LengthOfLastWord {

    /**
     * 双指针
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int begin = -1, end = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) != ' ') {
                    begin = i;
                    end = i + 1;
                }
            } else if (s.charAt(i - 1) == ' ' && s.charAt(i) != ' ') {
                begin = i;
                end = i + 1;
            } else if (s.charAt(i) != ' ') {
                end++;
            }
        }
        return end - begin;
    }

    /**
     * 从后往前遍历
     */
    public int lengthOfLastWordV2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            }
            if (count != 0 && s.charAt(i) == ' ') {
                break;
            }
        }
        return count;
    }

    /**
     * 从后往前遍历
     */
    public int lengthOfLastWordV3(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int length = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }

}
