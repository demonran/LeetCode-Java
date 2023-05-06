package com.lura.leetcode.struct;

/**
 * @ description: NodeTree
 * @ author: Liu Ran
 * @ data: 4/23/23 18:56
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }
    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
