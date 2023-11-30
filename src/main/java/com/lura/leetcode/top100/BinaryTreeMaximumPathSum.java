package com.lura.leetcode.top100;

import com.lura.leetcode.struct.TreeNode;

/**
 * BinaryTreeMaximumPathSum
 * 124. 二叉树中的最大路径和
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * @author Liu Ran
 */
public class BinaryTreeMaximumPathSum {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxRootPathSum(root);
        return res;
    }

    /**
     * 深度优先DFS
     */
    private int maxRootPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左右节点的最大sum
        // 如果<0 则不选取当前节点
        int left = Math.max(maxRootPathSum(root.left), 0);
        int right = Math.max(maxRootPathSum(root.right), 0);
        // 取每个节点作为根节点的最大sum
        res = Math.max(left + root.val + right, res);
        // 返回左右节点最大的值 + 当前节点的值
        return Math.max(left, right) + root.val;
    }
}
