package com.lura.leetcode.top100;

import com.lura.leetcode.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * ConstructBinaryTreeFromPreorderAndInorderTraversal
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * @author Liu Ran
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private Map<Integer, Integer> inorderMap = new HashMap<>();

    /**
     * 通过前序遍历确定根节点位置
     * 根据中序遍历确定左右节点数量
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0 , inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        // 前序遍历的第一个节点为根节点
        int rootVal = preorder[preStart];
        // 根节点在中序遍历的位置
        int rootIndex = inorderMap.get(rootVal);
        // 位置左边的即为左节点的子节点。
        int leftSize = rootIndex - inStart;

        TreeNode root = new TreeNode(rootVal);
        // 递归构造左节点 [preStart + 1, preStart + leftSize] [inStart, rootIndex - 1]
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1);
        // 递归构造左节点 [preStart + leftSize + 1, preEnd] [rootIndex + 1, inEnd]
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }
}
