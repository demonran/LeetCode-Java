package com.lura.leetcode.top100;

import com.lura.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * BinaryTreeLevelOrderTraversal
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * @author Liu Ran
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 方法一： 广度优先算法（BFS)。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size(); // 先获取当前层的节点数
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                // 插入下层的节点， 因为上面已经先计算了当前层的节点数，所以list只会add当前节点的值。
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            res.add(list);
        }
        return res;
    }
}
