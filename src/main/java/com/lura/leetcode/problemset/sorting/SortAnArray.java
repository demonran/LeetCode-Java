package com.lura.leetcode.problemset.sorting;

/**
 * QuickSort
 *
 * @author Liu Ran
 */
public class SortAnArray {

    public int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 快速排序
     *
     * @param nums
     * @param left
     * @param right
     */
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int i = left, j = right;
        // 使用随机基数
        int mid = (int) (Math.random() * (right - left + 1) + left);
        swap(nums, left, mid);

        int num = nums[left];

        while (i < j) {
            // 左边匹配的话，必须要先移动右指针
            while (i < j && nums[j] >= num) j--;
            while (i < j && nums[i] <= num) i++;
            swap(nums, i, j);
        }
        swap(nums, left, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                }
            }
        }
        return nums;
    }


    /**
     * 归并排序
     * @param nums
     * @return
     */
    int[] tmp;
    public int[] mergeSort(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right - left) / 2 + left;

        mergeSort(nums, 0, mid);
        mergeSort(nums, mid + 1, right);
        mergeTwoArray(nums, left, mid, right);
    }

    private void mergeTwoArray(int[] nums, int l, int m, int r) {
        for (int i = l; i <= r; i++) {
            tmp[i] = nums[i];
        }

        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i == m + 1) { // 左半边数组已经合并完毕
                nums[k] = tmp[j++];
            } else if (j == r + 1) { // 右半边数组已经合并完毕
                nums[k] = tmp[i++];
            } else if (tmp[i] < tmp[j]) { // 左边小，先合并左边
                nums[k] = tmp[i++];
            }else {
                nums[k] = tmp[j++];
            }
        }
    }
}
