package com.lura.leetcode.top100;

import com.lura.leetcode.struct.TreeNode;

/**
 * DiameterBinaryTree
 * 543. 二叉树的直径
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 * @author Liu Ran
 */
public class DiameterBinaryTree {

    /**
     * 方法一： 转换成求最大深度， 左子节点的最大深度 + 右子节点的最大深度 = 当前节点的最大直径
     */

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        // 后序遍历， 从最低端开始计算
        maxDiameter = Math.max(maxDiameter, maxLeft + maxRight);
        return 1 + Math.max(maxLeft, maxRight);
    }
}
