package com.lura.leetcode.tree;

import com.lura.leetcode.struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ description: PathSum
 * @ author: Liu Ran
 * @ data: 4/24/23 13:25
 */
public class PathSum {

    /**
     * DFS
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }

    /**
     * BFS
     */
    public boolean hasPathSumV2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> pathSumQueue = new LinkedList<>();
        queue.offer(root);
        pathSumQueue.offer(root.val);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer pathSum = pathSumQueue.poll();
            //叶子节点
            if (node.left == null && node.right == null) {
                if (sum == pathSum) {
                    return true;
                }
            }
            if (node.left != null) {
                queue.offer(node.left);
                pathSumQueue.offer(pathSum + node.left.val);
            }
            if (node.right != null) {
                queue.offer(node.right);
                pathSumQueue.offer(pathSum + node.right.val);
            }
        }

        return false;
    }
}
