package com.lura.leetcode.top100;

import com.lura.leetcode.struct.TreeNode;

import java.util.LinkedList;

/**
 * SymmetricTree
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @author Liu Ran
 */
public class SymmetricTree {

    /**
     * 方法一： 分解方法，分别比较每个节点的左右节点是否相等。
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);

    }

    /**
     * 比较两个节点是否是否相等
     * @param left
     * @param right
     * @return
     */
    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) { // 左右节点都为null，则是对称的
            return true;
        } else if (left == null || right == null) { // 一个为null，另一个不为null，则不为对称。
            return false;
        }
        // 左右节点的值相等 && 左节点的左子节点 == 右节点的右子节点 && 左节点的右子节点 == 右节点的左子节点
        return left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left);
    }


    /**
     * 方法二： 广度优先方法， 每次取两个节点进行对比
     */
    public boolean isSymmetricV2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root, root);

    }

    /**
     * 广度优先算法
     */
    private boolean check(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            p = queue.pop();
            q = queue.pop();

            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            // 插入一对待比较的节点
            queue.offer(p.left);
            queue.offer(q.right);
            // 插入另一对待比较的节点
            queue.offer(p.right);
            queue.offer(q.left);

        }
        return true;
    }

}
