package com.lura.leetcode.problemset.binarysearch;

/**
 * 704. 二分查找
 */
public class BinarySearch {

    public int binarySearch(int[] nums, int target) {
        // 空数据，直接返回-1
        if (nums.length == 0) {
            return  -1;
        }
        // 定义闭区间【0, length - 1】
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 找到target， 直接返回mid
                return mid;
            } else if (nums[mid] < target) {
                // 中位数 < 目标值， [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // [left , mid - 1]
                right = mid - 1;
            }
        }
        return -1;
    }
}
