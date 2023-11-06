package com.lura.leetcode.problemset.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 * @ description: FizzBuzz
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i （以字符串形式）如果上述条件全不满足。
 *
 * @ author: Liu Ran
 * @ data: 6/1/23 15:55
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            }else if (i % 3 ==0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            }else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}
