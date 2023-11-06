package com.lura.leetcode.problemset.tree;

import com.lura.leetcode.problemset.struct.TreeNode;

/**
 * @ description: MaximumDepthOfBinaryTree
 * @ author: Liu Ran
 * @ data: 5/4/23 21:32
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
