package com.lura.leetcode.top100;

import com.lura.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * BinaryTreeInorderTraversal
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * @author Liu Ran
 */
public class BinaryTreeInorderTraversal {
    /**
     * 递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }
    public void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }

    /**
     * 动态规划
     */
    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 添加左节点
        res.addAll(inorderTraversalV2(root.left));
        // 添加根节点
        res.add(root.val);
        // 添加右节点
        res.addAll(inorderTraversalV2(root.right));
        return res;
    }
}
