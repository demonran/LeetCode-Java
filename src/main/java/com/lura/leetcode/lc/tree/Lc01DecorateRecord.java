package com.lura.leetcode.lc.tree;

import com.lura.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Lc01DecorateRecord
 * 彩灯装饰记录 I
 * 一棵圣诞树记作根节点为 root 的二叉树，节点值为该位置装饰彩灯的颜色编号。请按照从 左 到 右 的顺序返回每一层彩灯编号。
 * @author Liu Ran
 */
public class Lc01DecorateRecord {

    /**
     * 广度优先算法
     * @param root
     * @return
     */

    public int[] decorateRecord(TreeNode root) {
        if(root == null) return new int[0];
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }


}
