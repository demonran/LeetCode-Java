package com.lura.leetcode.lc.tree;

import com.lura.leetcode.struct.TreeNode;

/**
 * Lc04IsSubStructure
 * 子结构判断
 * 给定两棵二叉树 tree1 和 tree2，判断 tree2 是否以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
 * 注意，空树 不会是以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
 *
 * @author Liu Ran
 */
public class Lc04IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 分别计算 顶点 || 左节点 || 右节点 是不是t2的顶点
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true; // 已经完全匹配完B
        if(A == null || A.val != B.val) return false; // B没匹配完，A已经匹配完了，或者值不相等。
        return recur(A.left, B.left) && recur(A.right, B.right); //递推匹配左右节点
    }
}
