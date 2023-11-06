package com.lura.leetcode.problemset.string;

/**
 * 168. Excel表列名称
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * @ description: ExcelSheetColumnTitle
 * @ author: Liu Ran
 * @ data: 5/25/23 13:05
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            char title = (char) (columnNumber % 26 + 'A');
            ans.append(title);
            columnNumber /= 26;
        }
        return ans.reverse().toString();
    }
}
