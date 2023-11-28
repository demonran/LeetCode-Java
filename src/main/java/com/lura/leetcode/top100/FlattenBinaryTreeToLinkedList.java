package com.lura.leetcode.top100;

import com.lura.leetcode.struct.TreeNode;

/**
 * FlattenBinaryTreeToLinkedList
 *
 * @author Liu Ran
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        // 将左子树作为右子树
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;

        // 设置左节点的最后一个节点的右节点为root的右节点。
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
