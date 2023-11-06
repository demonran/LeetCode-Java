package com.lura.leetcode.problemset.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给你一个整数，将其转为罗马数字。
 *
 * @ description: IntegerToRoman
 * @ author: Liu Ran
 * @ data: 6/20/23 15:55
 */
public class IntegerToRoman {
    Map<Character, Integer> map = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    List<Character> romans = new ArrayList<>() {{
        add('I');
        add('V');
        add('X');
        add('L');
        add('C');
        add('D');
        add('M');
    }};


    /**
     * 从大到小先取模再取商，
     * 处理个位为4的情况， 判断前一个字符是否一样，一样的话就合并。
     */
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        for (int i = romans.size() - 1; i >= 0; i--) {
            intToRoman(num, romans.get(i), ans);
            num %= map.get(romans.get(i));
        }
        return ans.toString();
    }

    private void intToRoman(int num, char c, StringBuilder ans) {
        int n = num / map.get(c);
        if (n == 4) {
            if (ans.length() > 0 && ans.charAt(ans.length() - 1) == next(c)) {
                ans.deleteCharAt(ans.length() - 1);
                ans.append(c);
                ans.append(next(next(c)));
            } else {
                ans.append(c);
                ans.append(next(c));
            }
        } else {
            for (int i = 0; i < n; i++) {
                ans.append(c);
            }
        }

    }

    private char next(char c) {
        return romans.get(romans.indexOf(c) + 1);
    }

    /**
     * 枚举可能存在的字符
     */
    public String intToRomanV2(int num) {
        Map<String, Integer> map = new LinkedHashMap<>() {{
            put("M", 1000);
            put("CM", 900);
            put("D", 500);
            put("CD", 400);
            put("C", 100);
            put("XC", 90);
            put("L", 50);
            put("XL", 40);
            put("X", 10);
            put("IX", 9);
            put("V", 5);
            put("IV", 4);
            put("I", 1);
        }};
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            while (num >= v) {
                ans.append(k);
                num -= v;
            }
        }
        return ans.toString();
    }

    public String intToRomanV3(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] one = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuilder ans = new StringBuilder();

        ans.append(thousands[num / 1000]);
        ans.append(hundreds[num % 1000 / 100]);
        ans.append(tens[num % 100 / 10]);
        ans.append(one[num % 10]);

        return ans.toString();
    }

}
