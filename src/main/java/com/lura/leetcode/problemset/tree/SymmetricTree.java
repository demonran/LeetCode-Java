package com.lura.leetcode.problemset.tree;

import com.lura.leetcode.struct.TreeNode;

/**
 * 是否是对称树
 *
 * @ description: SymmetricTree
 * @ author: Liu Ran
 * @ data: 5/4/23 21:35
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return check(p.left, q.right) && check(p.right, q.left);
    }

}
