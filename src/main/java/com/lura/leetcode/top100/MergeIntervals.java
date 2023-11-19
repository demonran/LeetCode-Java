package com.lura.leetcode.top100;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * MergeIntervals
 *
 56. 合并区间
 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 输出：[[1,6],[8,10],[15,18]]
 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * @author Liu Ran
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        // 先排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        LinkedList<int[]> res = new LinkedList<>();
        res.addLast(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] last = res.getLast();
            // 后一个的start < 前一个的end, 则进行合并
            if (curr[0] <= last[1]) {
                last[1] = Math.max(curr[1], last[1]);
            }else {
                res.add(curr);
            }
        }
        return res.toArray(new int[0][]);
    }
}
