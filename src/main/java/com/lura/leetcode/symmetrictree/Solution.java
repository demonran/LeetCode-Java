package com.lura.leetcode.symmetrictree;

import com.lura.leetcode.struct.TreeNode;

/**
 * @ description: Solution
 * @ author: Liu Ran
 * @ data: 4/24/23 10:41
 */
public class Solution {
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
