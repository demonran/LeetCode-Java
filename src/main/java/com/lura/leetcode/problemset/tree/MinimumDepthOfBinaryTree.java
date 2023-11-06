package com.lura.leetcode.problemset.tree;

import com.lura.leetcode.problemset.struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ description: MinimumDepthOfBinaryTree
 * @ author: Liu Ran
 * @ data: 5/4/23 21:33
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);

        if (root.left == null) {
            return m2 + 1;
        }
        if (root.right == null) {
            return m1 + 1;
        }

        return Math.min(m1, m2) + 1;
    }

    // 广度优先
    public int minDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;

        }
        return depth;
    }
}
