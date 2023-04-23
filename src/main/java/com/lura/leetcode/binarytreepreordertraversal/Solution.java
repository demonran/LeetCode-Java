package com.lura.leetcode.binarytreepreordertraversal;

import com.lura.leetcode.struct.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ description: Solution
 * @ author: Liu Ran
 * @ data: 4/23/23 19:14
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        preorder(root, res);

        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }


}
