package com.lura.leetcode.linkedlist;

import com.lura.leetcode.struct.ListNode;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * @ description: RemoveLinkedListElements
 * @ author: Liu Ran
 * @ data: 5/6/23 20:21
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1, head);
        ListNode cur = pre;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return pre.next;
    }
}
