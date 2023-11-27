package com.lura.leetcode.struct;

import java.util.Arrays;
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

    // [3,1,4,null,2]
    public static TreeNode fromList(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(list.get(0));
        queue.offer(root);
        int index = 1;
        while (index < list.size()) {
            TreeNode curr = queue.poll();
            Integer val = list.get(index++);
            TreeNode left = null;
            if (val != null) {
                left = new TreeNode(val);
            }
            if (curr != null) {
                curr.left = left;
            }

            queue.offer(left);
            if (index == list.size()) {
                break;
            }
            val = list.get(index++);
            TreeNode right = null;
            if (val != null) {
                right = new TreeNode(val);
            }
            if (curr != null) {
                curr.right = right;
            }
            queue.offer(right);

        }

        return root;
    }

}
