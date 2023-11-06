package com.lura.leetcode.problemset.tree;

import com.lura.leetcode.struct.TreeNode;

/**
 * @ description: SameTree
 * @ author: Liu Ran
 * @ data: 5/4/23 21:33
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
