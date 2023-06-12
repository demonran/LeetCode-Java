package com.lura.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 696. 计数二进制子串
 * 给定一个字符串s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
 *
 * 重复出现（不同位置）的子串也要统计它们出现的次数。
 *
 * @ description: CountBinarySubstrings
 * @ author: Liu Ran
 * @ data: 6/12/23 17:03
 */
public class CountBinarySubstrings {

    /**
     *  把相同的数字转换成对应的列表 11001110 => 2231
     *  取相邻两个中最小的数，就是两个可以组成的个数。
     */
    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<>();

        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ptr++;
                count++;
            }
            counts.add(count);
        }

        int ans = 0;
        for (int i = 1; i < counts.size(); i++) {
            ans += Math.min(counts.get(i - 1), counts.get(i));
        }
        return ans;
    }

    /**
     *  每次算完后就计算字串数量，减少ArrayList的空间
     */
    public int countBinarySubstringsV2(String s) {
       int lastCount = 0, ans = 0;

        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ptr++;
                count++;
            }
            ans += Math.min(lastCount, count);
            lastCount = count;
        }

        return ans;
    }
}
