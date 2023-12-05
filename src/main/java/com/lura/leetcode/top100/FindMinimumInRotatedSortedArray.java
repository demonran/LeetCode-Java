package com.lura.leetcode.top100;

/**
 * FindMinimumInRotatedSortedArray
 *
 * @author Liu Ran
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {  // 右边升序
                right = mid;  // mid有可能是最小的数
            }else {  // 左边升序， mid一定不是最小的数
                left = mid + 1;
            }
        }
        return nums[left]; // left == right == min
    }
}
