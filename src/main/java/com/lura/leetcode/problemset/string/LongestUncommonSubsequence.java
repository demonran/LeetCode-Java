package com.lura.leetcode.problemset.string;

/**
 * 521. 最长特殊序列 Ⅰ
 * 给你两个字符串a和b，请返回 这两个字符串中 最长的特殊序列 的长度。如果不存在，则返回 -1。
 * 「最长特殊序列」定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * 字符串s的子序列是在从s中删除任意数量的字符后可以获得的字符串。
 * 例如，"abc" 是 "aebdc" 的子序列，因为删除 "aebdc" 中斜体加粗的字符可以得到 "abc" 。 "aebdc" 的子序列还包括 "aebdc" 、 "aeb" 和 "" (空字符串)。
 *
 * @ description: LongestUncommonSubsequence
 * @ author: Liu Ran
 * @ data: 6/14/23 15:42
 */
public class LongestUncommonSubsequence {

    /**
     * 如果两个字符串相等，则没有特殊子序列
     * 如果两个字符串不想等，那么长的那个字符串本身就是 最长特殊序列
     */
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
