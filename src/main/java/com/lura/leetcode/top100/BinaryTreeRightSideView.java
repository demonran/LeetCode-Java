package com.lura.leetcode.top100;

import com.lura.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * BinaryTreeRightSideView
 * 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * @author Liu Ran
 */
public class BinaryTreeRightSideView {

    /**
     * 广度优先算法，
     * 遍历之后取最后一个元素的值
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size(); // 获取当前层右多少个元素
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                // 取最后一个元素的值
                if (i == size - 1) {
                    res.add(curr.val);
                }
            }
        }
        return res;
    }
}
