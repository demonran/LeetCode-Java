package com.lura.leetcode.string;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 *
 * @ description: RepeatedSubstringPattern
 * @ author: Liu Ran
 * @ data: 6/13/23 15:44
 */
public class RepeatedSubstringPattern {
    /**
     * s + s 去掉头和尾后， 包含s, 则为重复子串
     */
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    /**
     * 遍历子串，子串长度从1 - n/2
     * n一定是子串长度的倍数
     * 后一个子串一定和前一个子串一样。
     */
    public boolean repeatedSubstringPatternV2(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; i++) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    // 后一个子串 == 前一个子串 相当于 s.substring(0, i) == s.substring(j， i)
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}
