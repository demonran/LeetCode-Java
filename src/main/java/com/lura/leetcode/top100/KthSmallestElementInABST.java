package com.lura.leetcode.top100;

import com.lura.leetcode.struct.TreeNode;

/**
 * KthSmallestElementInABST
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * @author Liu Ran
 */
public class KthSmallestElementInABST {
    int n = 1;
    Integer res = null;

    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return res;

    }

    /**
     * 中序遍历， 每遍历一次，n+1。 当遍历到k时停止遍历。
     * @param root
     * @param k
     */
    private void inorderTraversal(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, k);
        if (n == k) {
            res = root.val;
            return;
        }
        n++;
        inorderTraversal(root.right, k);
    }
}
