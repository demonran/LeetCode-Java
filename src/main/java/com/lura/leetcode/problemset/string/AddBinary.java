package com.lura.leetcode.problemset.string;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * @ description: AddBinary
 * @ author: Liu Ran
 * @ data: 5/24/23 13:17
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int n = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < n; i++) {
            int val = carry;
            val += i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            val += i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            ans.append(val % 2);
            carry = val / 2;
        }
        if (carry > 0) {
            ans.append('1');
        }
        return ans.reverse().toString();

    }
}
