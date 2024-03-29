package com.lura.leetcode.top100;

/**
 * RotateArray
 * 189. 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * @author Liu Ran
 */
public class RotateArray {

    /**
     * 临时数组记录前移的数据。
     * [1, 2, 3, 4, 5] k=2
     * tmp =[4, 5]
     * 然后移动[1,2,3]
     * [4, 5, 1, 2, 3]
     * 再补齐tmp
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = nums[nums.length - k + i];
        }

        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = tmp[i];
        }
    }

    /**
     * 三次翻转
     * [1, 2, 3, 4, 5] k=2
     * 第一次： [5, 4, 3, 2, 1]
     * 第二次：[4, 5, 3, 2, 1]
     * 第三次: [4, 5, 1, 2, 3]
     *
     * @param nums
     * @param k
     */
    public void rotateV2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
