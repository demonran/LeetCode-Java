package com.lura.leetcode.string;

/**
 * 522. 最长特殊序列 II
 * 给定字符串列表strs ，返回其中 最长的特殊序列的长度。如果最长特殊序列不存在，返回 -1 。
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 * s的子序列可以通过删去字符串s中的某些字符实现。
 * 例如，"abc"是 "aebdc"的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc"。"aebdc"的子序列还包括"aebdc"、 "aeb"和 ""(空字符串)。
 *
 * @ description: LongestUncommonSubsequence2
 * @ author: Liu Ran
 * @ data: 6/14/23 16:19
 */
public class LongestUncommonSubsequence2 {
    /**
     * 找个均不是其他字符串的子序列的最长字符串的长度，就是本题的结果。
     * 双重遍历判断当前字符串是否是其他字符串的子序列
     */
    public int findLUSlength(String[] strs) {
        int ans = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean check = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubSeq(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    private boolean isSubSeq(String s, String t) {
        int ps = 0, pt = 0;
        while (ps < s.length() && pt < t.length()) {
            if (s.charAt(ps) == t.charAt(pt)) {
                ps++;
            }
            pt++;
        }
        return ps == s.length();
    }
}
