package com.lura.leetcode.problemset.struct;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ description: TreeNodes
 * @ author: Liu Ran
 * @ data: 5/6/23 18:54
 */
public class TreeNodes {

    public static List<Integer> toList(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur == null) {
                res.add(null);
                continue;
            }
            res.add(cur.val);

            queue.offer(cur.left);
            queue.offer(cur.right);
        }

        while (!res.isEmpty() && res.getLast() == null) {
            res.removeLast();
        }

        return res;
    }

}
