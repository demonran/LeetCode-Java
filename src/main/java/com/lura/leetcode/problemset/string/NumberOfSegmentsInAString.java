package com.lura.leetcode.problemset.string;

/**
 * 434. 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * @ description: NumberOfSegmentsInAString
 * @ author: Liu Ran
 * @ data: 6/6/23 17:14
 */
public class NumberOfSegmentsInAString {

    public int countSegments(String s) {
        int ans = 0;
        char pre = ' ';
        for (char c : s.toCharArray()) {
            if (c != ' ' && pre == ' ') {
                ans++;
            }
            pre = c;
        }
        return ans;
    }
}
