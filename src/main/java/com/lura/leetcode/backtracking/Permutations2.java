package com.lura.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * @ description: Permutations
 * @ author: Liu Ran
 * @ data: 4/26/23 14:41
 */
public class Permutations2 {

    private final List<List<Integer>> res = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, new LinkedList<>());
        return res;
    }

    //回溯方法
    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            //要创建新的List,复制出来之前的值
            res.add(new LinkedList<>(track));
            return;
        }



        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 固定位置， 如果前面的没有用过， 后面就不能用。
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1] ) {
                continue;
            }
            used[i] = true;
            track.addLast(nums[i]);
            backtrack(nums, track);
            track.removeLast();
            used[i] = false;
        }
    }
}
