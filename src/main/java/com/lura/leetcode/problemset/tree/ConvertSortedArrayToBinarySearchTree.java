package com.lura.leetcode.problemset.tree;

import com.lura.leetcode.struct.TreeNode;

/**
 * @ description: ConvertSortedArrayToBinarySearchTree
 * @ author: Liu Ran
 * @ data: 4/24/23 11:25
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0) {
            return null;
        }

        return sort(nums, 0, nums.length - 1);


    }

    private TreeNode sort(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);

        treeNode.left = sort(nums, left, mid - 1);
        treeNode.right = sort(nums, mid + 1, right);

        return treeNode;
    }
}
