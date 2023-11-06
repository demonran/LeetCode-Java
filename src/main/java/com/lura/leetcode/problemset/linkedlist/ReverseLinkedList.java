package com.lura.leetcode.problemset.linkedlist;

import com.lura.leetcode.struct.ListNode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        // 递归，前序遍历
        ListNode last = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode reverseListV2(ListNode head) {
        // 前后指针交换
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
