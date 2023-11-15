package com.lura.leetcode.top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LongestConsecutiveSequence
 * 128. 最长连续序列
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * @author Liu Ran
 */
public class LongestConsecutiveSequence {

    /**
     * 使用hash表，用空间换时间， 每次找一个数据，然后while找+1的值是否存在，然后计数，while结束后取最大值。
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ret = 0;
        for (int num : nums) {
            // 避免重复执行， 只有第一个数才会走while循环。
            if (set.contains(num - 1)) {
                continue;
            }
            int curr = num;
            int ctn = 1;
            while (set.contains(curr)) {
                ctn++;
                curr++;
            }
            ret = Math.max(ret, ctn);
        }
        return ret;

    }

    /**
     * 并查集， p[4] = p[3] = p[2] = p[1] = 1
     *
     * @param nums
     * @return
     */
    int[] p;
    public int longestConsecutiveV2(int[] nums) {
        int n = nums.length;
        p = new int[n];
        int[] size = new int[n];
        Arrays.fill(size, 1);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        int index = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, index++);
            }
        }


        for (int num : nums) {
            if (!map.containsKey(num + 1)) {
                continue;
            }
            int index1 = map.get(num);
            int index2 = map.get(num + 1);
            int fd1 = find(index1);
            int fd2 = find(index2);
            if (fd1 == fd2) {
                continue;
            }
            p[fd1] = fd2;
            size[fd2] += size[fd1];
        }

        int res = 0;
        for (int i : size) {
            if (i > res) {
                res = i;
            }
        }
        return res;

    }

    public int find(int x) {
        if (p[x] == x) {
            return x;
        }else {
            p[x] = find(p[x]);
            return p[x];
        }
    }
}
