package com.lura.leetcode.sametree;

import com.lura.leetcode.struct.TreeNode;

/**
 * @ description: Solution
 * @ author: Liu Ran
 * @ data: 4/24/23 09:59
 */
public class Solution {

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
