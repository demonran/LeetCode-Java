package com.lura.leetcode.maximumdepthofbinarytree;

import com.lura.leetcode.struct.TreeNode;

/**
 * @ description: Solution
 * @ author: Liu Ran
 * @ data: 4/23/23 19:24
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
