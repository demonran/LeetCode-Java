package com.lura.leetcode.problemset.tree;

import com.lura.leetcode.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ description: HouseRobberI2
 * @ author: Liu Ran
 * @ data: 4/24/23 16:21
 */
public class HouseRobber3 {

    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int selected = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        int notSelected = rob(root.left) + rob(root.right);
        int res = Math.max(selected, notSelected);
        memo.put(root, res);
        return res;
    }

    public int robV2(TreeNode root) {
        int[] rob = dfs(root);
        return Math.max(rob[0], rob[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int selected = root.val + left[1] + right[1];
        int notSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{selected, notSelected};
    }
}
