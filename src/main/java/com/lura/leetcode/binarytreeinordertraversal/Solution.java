package com.lura.leetcode.binarytreeinordertraversal;

import com.lura.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ description: Solution
 * @ author: Liu Ran
 * @ data: 4/23/23 18:55
 */
public class Solution {

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
