package com.lura.leetcode.top100;

import com.lura.leetcode.struct.TreeNode;

/**
 * MaximumDepthOfBinaryTree
 * 104. 二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * @author Liu Ran
 */
public class MaximumDepthOfBinaryTree {

    /**
     * 动态规划
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左节点的最大高度
        int leftMax = maxDepth(root.left);
        // 右节点的最大高度
        int rightMax = maxDepth(root.right);
        // 当前节点的最大深度 = 左右节点最大深度 + 1
        return 1 + Math.max(leftMax, rightMax);
    }

    /**
     * 回溯算法，遍历二叉树
     */
    int depth = 0;
    int res = 0;
    public int maxDepthV2(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
