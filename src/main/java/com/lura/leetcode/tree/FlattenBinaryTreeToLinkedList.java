package com.lura.leetcode.tree;

import com.lura.leetcode.struct.TreeNode;

/**
 * @ description: FlattenBinaryTreeToLinkedList
 * @ author: Liu Ran
 * @ data: 4/24/23 17:25
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;


        root.right = left;
        root.left = null;


    }
}
