package com.lura.leetcode.lc.tree;

import com.lura.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Lc03DecorateRecord3
 * 彩灯装饰记录 III
 * 一棵圣诞树记作根节点为 root 的二叉树，节点值为该位置装饰彩灯的颜色编号。请按照如下规则记录彩灯装饰结果：
 * <p>
 * 第一层按照从左到右的顺序记录
 * 除第一层外每一层的记录顺序均与上一层相反。即第一层为从左到右，第二层为从右到左。
 *
 * @author Liu Ran
 */
public class Lc03DecorateRecord3 {


    public List<List<Integer>> decorateRecord(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            // 双端队列
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 1){
                    // 倒数
                    tmp.addFirst(node.val);
                }else {
                    // 正序
                    tmp.addLast(node.val);
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
