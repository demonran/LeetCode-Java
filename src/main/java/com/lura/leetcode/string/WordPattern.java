package com.lura.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * 给定一种规律 pattern和一个字符串s，判断 s是否遵循相同的规律。
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串s中的每个非空单词之间存在着双向连接的对应规律。
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 *
 * @ description: WordPattern
 * @ author: Liu Ran
 * @ data: 5/29/23 15:58
 */
public class WordPattern {

    /**
     * 双向映射
     */
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> m1 = new HashMap<>();
        Map<String, Character> m2 = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            Character x = pattern.charAt(i);
            String word = words[i];

            if ((m1.containsKey(x) && !m1.get(x).equals(word)) || (m2.containsKey(word) && m2.get(word) != x)) {
                return false;
            }
            m1.put(x, word);
            m2.put(word, x);
        }
        return true;
    }

    /**
     * 单map方式
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPatternV2(String pattern, String s) {
        String[] words = s.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> m1 = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            Character x = pattern.charAt(i);
            String word = words[i];

            if (m1.containsKey(x)) {
                //存在映射，但是值不一样，返回false
                if (!m1.get(x).equals(word)) {
                    return false;
                }
            }else {
                // word被其他pattern映射了
                if (m1.containsValue(word)) {
                    return false;
                }
                m1.put(x, word);
            }

        }
        return true;
    }

}
