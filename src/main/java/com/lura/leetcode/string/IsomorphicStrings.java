package com.lura.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * @ description: IsomorphicStrings
 * @ author: Liu Ran
 * @ data: 5/26/23 09:09
 */
public class IsomorphicStrings {

    /**
     * 双向映射
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if ((map1.containsKey(x) && map1.get(x) != y) || (map2.containsKey(y) &&  map2.get(y) != x)) {
               return false;
            }
            map1.put(x, y);
            map2.put(y, x);
        }
        return true;
    }

    /**
     * 翻译成数字
     */
    public boolean isIsomorphicV2(String s, String t) {
        return translate(s).equals(translate(t));
    }

    private String translate(String s) {
       int[] map = new int[26];
       int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (map[index] == 0) {
                map[index] = count;
                count++;
            }
            sb.append(map[index]);
        }
        return sb.toString();
    }

    /**
     * 转换成数字，一个一个比较
     */
    public boolean isIsomorphicV3(String s, String t) {
       int n = s.length();
       int[] map1 = new int[26];
       int[] map2 = new int[26];
        for (int i = 0; i < n; i++) {
            int c1 = s.charAt(i) - 'a';
            int c2 = s.charAt(i) - 'a';
            if (map1[c1] != map2[c2]) {
                return false;
            }else {
                if (map1[c1] == 0) {
                    map1[c1] = i + 1;
                    map2[c2] = i + 1;
                }
            }
        }
        return true;
    }

}
