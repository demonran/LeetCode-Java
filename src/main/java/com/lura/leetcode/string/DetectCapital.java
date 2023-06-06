package com.lura.leetcode.string;

/**
 * 520. 检测大写字母
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写，比如"Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 *
 * @ description: DetectCapital
 * @ author: Liu Ran
 * @ data: 6/6/23 22:01
 */
public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

        for (int i = 2; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(1)) ^ Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }

        return true;

    }
}
