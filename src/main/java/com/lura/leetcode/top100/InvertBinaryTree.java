package com.lura.leetcode.top100;

import com.lura.leetcode.struct.TreeNode;

/**
 * InvertBinaryTree
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @author Liu Ran
 */
public class InvertBinaryTree {

    /**
     * 分解思路，动态规划
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 先存储临时变量，方便下面使用
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 翻转right节点， 赋值给root.left
        root.left = invertTree(right);
        // 翻转left节点，赋值给root.right
        root.right = invertTree(left);

        return root;
    }

    /**
     * 二叉树遍历，遍历前先进行左右节点交换
     * @param root
     * @return
     */
    public TreeNode invertTreeV2(TreeNode root) {
        reverse(root);
        return root;
    }

    // 前序遍历， 遍历前先交换左右节点
    private void reverse(TreeNode node) {
        if (node == null) {
            return;
        }
        // 前序遍历
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        // 递归遍历左右节点
        reverse(node.left);
        reverse(node.right);
    }
}
