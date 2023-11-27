package com.lura.leetcode.top100;

import com.lura.leetcode.struct.TreeNode;


/**
 * ConvertSortedArrayToBinarySearchTree
 * 108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * @author Liu Ran
 */
public class ConvertSortedArrayToBinarySearchTree {
    /**
     * 二叉搜索树的中序遍历是升序序列， 高度平衡的二叉树，选择数组的中间位置作为根节点。
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return inorderTraversal(nums, 0, nums.length - 1);
    }

    /**
     * 将闭区间的数组转换成二叉树 [left,  right]
     */
    private TreeNode inorderTraversal(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }
        // 获取根节点
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // 处理[left, mid - 1]
        root.left = inorderTraversal(nums, left, mid - 1);
        // 处理 [mid + 1, right]
        root.right = inorderTraversal(nums, mid + 1, right);
        return root;
    }
}
