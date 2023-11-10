package com.lura.leetcode.problemset.string;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @ description: LongestCommonPrefix
 * @ author: Liu Ran
 * @ data: 5/21/23 20:06
 */
public class LongestCommonPrefix {

    /**
     * 纵向遍历
     */
    public String longestCommonPrefix(String[] strs) {
        // i为竖向指针，往右移动
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                // 如果存在比指针短， 或者两个字符不想等，则跳出
                if (i >= strs[j + 1].length() || strs[j].charAt(i) != strs[j + 1].charAt(i) ) {
                    return strs[j].substring(0, i);
                }
            }
        }
        return strs[0];
    }


    /**
     * 横向遍历
     */
    public String longestCommonPrefixV2(String[] strs) {
        String lcp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            lcp = longestCommonPrefix(lcp, strs[i]);
        }
        return lcp;
    }

    /**
     *  两个字符串的公共前缀
     * @param str1
     * @param str2
     * @return
     */
    private String longestCommonPrefix(String str1, String str2) {
        int min = Math.min(str1.length(), str2.length());

        for (int i = 0; i < min; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                // 找到第一个不相同的字符则停止
                return str1.substring(0, i);
            }
        }
        return str1;
    }
}
