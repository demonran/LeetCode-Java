package com.lura.leetcode.problemset.string;

/**
 * 345. 反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 *
 * @ description: ReverseVowelsOfAString
 * @ author: Liu Ran
 * @ data: 5/30/23 13:04
 */
public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left < right) {
            while (left < n && !isVowel(arr[left])) {
                left++;
            }
            while (right > left && !isVowel(arr[right])) {
                right--;
            }
            if (left < right) {
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right]= tmp;
            }
            left++;
            right--;
        }
        return new String(arr);
    }

    private boolean isVowel(char c) {
        return "aoeiuAOEIU".indexOf(c) >= 0;
    }
}
