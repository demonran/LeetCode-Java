package com.lura.leetcode.tree;

import com.lura.leetcode.struct.TreeNode;

/**
 * @ description: FlattenBinaryTreeToLinkedList
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @ author: Liu Ran
 * @ data: 4/24/23 17:25
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;


        root.right = left;
        root.left = null;

        // 右节点挂在左节点的右子节点后
        //寻找左节点的右子节点
        while (root.right != null) {
            root = root.right;
        }
        root.right = right;

    }
}
