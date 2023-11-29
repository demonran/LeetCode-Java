package com.lura.leetcode.top100;

import com.lura.leetcode.struct.TreeNode;

/**
 * PathSum3
 * 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * @author Liu Ran
 */
public class PathSum3 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // 当前节点作为根节点符合target的个数
        int ret = rootSum(root, targetSum);
        // 左节点作为根节点查找符合target的个数
        ret += pathSum(root.left, targetSum);
        // 右节点作为根节点查找符合target的个数
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    /**
     * 当前节点作为起点，查找符合targetSum的个数
     */
    private int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        if (root.val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - root.val);
        ret += rootSum(root.right, targetSum - root.val);
        return ret;
    }
}
