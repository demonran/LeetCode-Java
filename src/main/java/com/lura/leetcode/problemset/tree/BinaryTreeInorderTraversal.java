package com.lura.leetcode.problemset.tree;

import com.lura.leetcode.problemset.struct.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ description: BinaryTreeInorderTraversal
 * @ author: Liu Ran
 * @ data: 5/4/23 21:30
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new LinkedList<>();

        inorder(root, res);

        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
