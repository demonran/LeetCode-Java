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

    /**
     * 双指针， 交换位置，
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] != 0) { // 不为0 则移动左指针
                left++;
                continue;
            }
            for (int j = left + 1; j < right; j++) { // 移动到最后位置
                int tmp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = tmp;
            }
             right--; // 前移右指针
        }
    }

    /**
     * 双指针，快慢指针
     * @param nums
     */
    public void moveZeroesV2(int[] nums) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     *  双指针，一次遍历
     *  i=0, j=0: 0 1 0 2
     *  i=1, j=1: 1 0 0 2
     *  i=2, j=1: 1 0 0 2
     *  i=3, j=2: 1 2 0 0
     * @param nums
     */
    public void moveZeroesV3(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) { // 如果不等0， 就和i交换位置， if i!=0 则 i==j， 此时i j 一起前进
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }

    }

}
