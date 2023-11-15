package com.lura.leetcode.top100;

/**
 * MoveZeros
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * @author Liu Ran
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] != 0) {
                left++;
                continue;
            }
            for (int j = left + 1; j < right; j++) {
                int tmp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = tmp;
            }
            right--;
        }
    }
}
