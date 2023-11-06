package com.lura.leetcode.problemset.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 383. 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次.
 *
 * @ description: RansomNote
 * @ author: Liu Ran
 * @ data: 5/30/23 13:20
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstructV2(String ransomNote, String magazine) {
        List<Character> r = new ArrayList<>();
        for (char c : ransomNote.toCharArray()) {
            r.add(c);
        }
        for (char c : magazine.toCharArray()) {
            if (r.contains(c)) {
                r.remove((Character) c);
            }
        }
        return r.isEmpty();
    }
}
