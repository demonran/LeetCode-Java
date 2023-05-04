package com.lura.leetcode.tree;

import com.lura.leetcode.struct.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ description: BinaryTreePreorderTraversal
 * @ author: Liu Ran
 * @ data: 5/4/23 21:31
 */
public class BinaryTreePreorderTraversal {
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
