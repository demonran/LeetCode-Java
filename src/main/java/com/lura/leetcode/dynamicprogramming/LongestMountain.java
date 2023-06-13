package com.lura.leetcode.dynamicprogramming;

/**
 * @ description: LongestMountain
 * @ author: Liu Ran
 * @ data: 5/4/23 21:36
 */
public class LongestMountain {

    /**
     *  找山顶
     *  i为某个点， left[i]为左边递增的数量， right[i]为右边递减的数量
     *  left[i]和right[i]都大于0，则为山顶。
     *  left[i] + right[i]为山脉长度。
     */
    public int longestMountain(int[] arr) {
        int ans = 0;

        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        int[] left = new int[n];
        for (int i = 1; i < n; i++) {
            // 上坡
            if (arr[i - 1] < arr[i]) {
                left[i] = left[i - 1] + 1;
            }
        }

        int[] right = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        for (int i = 1; i < n; i++) {
            if (left[i] > 0 && right[i] > 0) {
                return left[i] + right[i] + 1;
            }
        }

        return ans;
    }

    /**
     * 找山脚
     * 双指针， 找两边的山脚。
     */
    public int longestMountainV2(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        int left = 0;
        int ans = 0;

        while (left + 2 < n) {
            int right = left + 1;
            // 山脚
            if (arr[left] < arr[left + 1]) {
                //上坡
                while (right + 1 < n && arr[right] < arr[right + 1]) {
                    right++;
                }
                //山顶： 此时right-1为山顶
                if (right + 1 < n && arr[right] > arr[right +1]) {
                    //下坡
                    while (right + 1 < n && arr[right] > arr[right +1]) {
                        right++;
                    }
                    ans = Math.max(ans, right - left + 1);
                }
            }
            left = right;
        }

        return ans;

    }
}
