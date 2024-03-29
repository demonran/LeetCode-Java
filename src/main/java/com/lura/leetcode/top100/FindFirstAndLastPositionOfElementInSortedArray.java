package com.lura.leetcode.top100;

/**
 * FindFirstAndLastPositionOfElementInSortedArray
 *
 * @author Liu Ran
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }

    public int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                right = mid;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left ;
    }

    public int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (right == 0 || nums[right - 1] != target) {
            return -1;
        }
        return right - 1;
    }
}
