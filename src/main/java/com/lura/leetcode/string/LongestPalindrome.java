package com.lura.leetcode.string;

/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * 不管顺序
 * @ description: LongestPalindrome
 * @ author: Liu Ran
 * @ data: 6/1/23 15:38
 */
public class LongestPalindrome {

    /**
     * 最长回文， 只有最多一个字符出现了奇数次，其余的字符都出现偶数次。
     */
    public int longestPalindrome(String s) {
        int[] cnt = new int[128];
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }

        int ans = 0;
        for (int i : cnt) {
            ans += i / 2 * 2;
            // 第一次增加一个奇数。 后面都不会满足 ans % 2 == 0
            if (i % 2 == 1 && ans % 2 == 0) {
                ans += 1;
            }
        }
        return ans;
    }
}
