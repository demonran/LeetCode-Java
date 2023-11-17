package com.lura.leetcode.top100;

import java.util.LinkedList;

/**
 * SlidingWindowMaxNum
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * @author Liu Ran
 */
public class SlidingWindowMaxNum {

    /**
     * 单调队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) { // 先填充k-1个数据
                // 插入数据时移除比自己小的数据，
                while (!queue.isEmpty() && queue.getLast() < nums[i]) queue.pollLast();
                queue.addLast(nums[i]);
            } else {
                while (!queue.isEmpty() && queue.getLast() < nums[i]) queue.pollLast();
                queue.addLast(nums[i]);
                // 第一个即为最大值
                res[i + 1 - k] = queue.getFirst();
                // 如果要移除的数据刚好在第一个，则移除。
                if (queue.getFirst() == nums[i + 1 - k]) {
                    queue.pollFirst();
                }
            }
        }
        return res;
    }
}
