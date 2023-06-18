package com.lura.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 6. N 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * @ description: ZigzagConversion
 * @ author: Liu Ran
 * @ data: 6/17/23 17:10
 */
public class ZigzagConversion {

    /**
     * 用一个StringBuilder存放每一行的字符
     * 然后把每一行的字符串合起来
     */
    public String convert(String s, int numRows) {

        int n = s.length();
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> strs = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            strs.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            strs.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder str : strs) {
            ans.append(str);
        }
        return ans.toString();
    }

    /**
     * 二维表存储每一行的字符
     * 一个周期为 2 * numRows - 2, 一个周期占用 numRows -2 + 1列。
     * 行 r = numRows, 列 c = n / (2 * numRows - 2) * (numRows -2 + 1)
     */
    public String convertV2(String s, int numRows) {

        int n = s.length();
        if (numRows < 2) {
            return s;
        }
        int t = 2 * numRows - 2;
        // (n + t - 1 / t) 解决最后一个周期问题， 如果最后一个周期刚刚好，加t-1 和不加相等。
        int c = (n + t - 1) / t * (numRows - 2 + 1);
        char[][] arr = new char[numRows][c];
        for (int i = 0, x = 0, y = 0; i < n; i++) {
            arr[x][y] = s.charAt(i);
            if (i % t < numRows - 1) {
                x++;
            } else {
                x--;
                y++;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] != 0) {
                    ans.append(arr[i][j]);
                }
            }
        }
        return ans.toString();
    }

    /**
     * 顺序写入字符
     * 一个周期为 2 * numRows - 2,
     * 第一行和最后一行添加一个字符， 中间的分别添加两个 i 和 t - i
     */
    public String convertV3(String s, int numRows) {

        int n = s.length();
        if (numRows < 2) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int t = 2 * numRows - 2;
        // 枚举结果的行
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += t) {
                ans.append(s.charAt(j + i)); // 每个周期的第一列。
                // 每个周期的第二列（第一行和最后一行只有一列）
                if (i > 0 && i < numRows - 1 && j + (t - i) < n) {
                    ans.append(s.charAt(j + (t - i)));
                }
            }
        }
        return ans.toString();

    }
}
