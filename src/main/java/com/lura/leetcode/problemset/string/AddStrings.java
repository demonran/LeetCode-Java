package com.lura.leetcode.problemset.string;

/**
 * @ description: AddStrings
 * @ author: Liu Ran
 * @ data: 6/5/23 18:41
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int n = Math.max(num1.length(), num2.length());
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = num1.length() > i ? num1.charAt(num1.length() - i - 1) - '0' : 0;
            int y = num2.length() > i ? num2.charAt(num2.length() - i - 1) - '0' : 0;
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        if (carry > 0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public String addStringsV2(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

}
