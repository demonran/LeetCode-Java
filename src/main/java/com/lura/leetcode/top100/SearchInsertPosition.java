package com.lura.leetcode.top100;

/**
 * SearchInsertPosition
 *
 * @author Liu Ran
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        // 使用左闭右开区间[left, right)
        int left = 0, right = nums.length;
        // 当left == right时退出循环，因为right为开区间
        while (left < right) {
            // 计算中间位置， 使用减法，避免越界
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) { // 中间值==目标值时，直接返回
                return mid;
            } else if (nums[mid] < target) { // 中间值小于目标值 [mid +1 , right)
                left = mid + 1;
            } else { //中间值大于目标值, [left, mid)
                right = mid;
            }
        }
        return left;
    }
}
