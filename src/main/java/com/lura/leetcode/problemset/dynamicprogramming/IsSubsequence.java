package com.lura.leetcode.problemset.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 392. 判断子序列
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * @ description: IsSubsequence
 * @ author: Liu Ran
 * @ data: 4/25/23 20:31
 */
public class IsSubsequence {

    //双指针， 相同就一起后移， 不同就只移被匹配的， 最后判断匹配的字符串的指针位置。
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    // 二分查找法
    // 1. 先预处理数据， 保存每个字符的位置
    // 2. 查找字符的位置是否包含大于指的数的位置
    public boolean isSubsequenceV2(String s, String t) {
        Map<Character, List<Integer>> index = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            List<Integer> list = index.getOrDefault(c, new ArrayList<>());
            list.add(i);
            index.putIfAbsent(c, list);
        }

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (index.get(c) == null) {
                return false;
            }
            int pos = leftBound(index.get(c), j);
            if (pos == -1) {
                return false;
            }
            j = index.get(c).get(pos) + 1;

        }
        return true;
    }


    private int leftBound(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) < target) {
                left = mid + 1;
            } else if (arr.get(mid) > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        if (left == arr.size()) {
            return -1;
        }
        return left;
    }
}
