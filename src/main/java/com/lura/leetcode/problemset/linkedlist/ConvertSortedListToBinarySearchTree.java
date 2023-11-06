package com.lura.leetcode.problemset.linkedlist;

import com.lura.leetcode.struct.ListNode;
import com.lura.leetcode.struct.TreeNode;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表的头节点 head，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差不超过 1。
 *
 * @ description: ConvertSortedListToBinarySearchTree
 * @ author: Liu Ran
 * @ data: 5/6/23 18:34
 */
public class ConvertSortedListToBinarySearchTree {

    private ListNode globalHead;

    /**
     * 因为是平衡二叉树，所以要先找中间的节点作为根节点。
     * 用快慢指针找根节点
     * 递归组装左右子节点
     */
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);

        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    private ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 使用中序遍历
     */
    public TreeNode sortedListToBSTV2(ListNode head) {
        // 定义全局globalHead是为了保证每个节点只使用一次， 用队列也可以。
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);

    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }

    private int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ret++;
            head = head.next;
        }
        return ret;
    }
}
