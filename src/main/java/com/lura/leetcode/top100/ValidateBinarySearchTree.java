package com.lura.leetcode.top100;

import com.lura.leetcode.struct.TreeNode;

/**
 * ValidateBinarySearchTree
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @author Liu Ran
 */
public class ValidateBinarySearchTree {

    // 使用long类型，处理Integer.MIN_VALUE边界值
    long p = Long.MIN_VALUE;
    /**
     * 中序遍历
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (p > root.val) {
            return false;
        }
        p = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;

    }

    public boolean isValidBSTV2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        // 左子节点不大于当前节点， 右子节点不小于当前节点
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
