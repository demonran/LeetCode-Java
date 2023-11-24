package com.lura.leetcode.top100;

import com.lura.leetcode.struct.ListNode;

/**
 * RemoveNthNodeFromEndOfLinkedList
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @author Liu Ran
 */
public class RemoveNthNodeFromEndOfLinkedList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        // 快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 定义一个dummy节点，规避head被删除的情况
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        // 快指针到null是，slow即为倒数第n个节点。
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        // 删除节点
        pre.next = slow.next;

        return dummy.next;
    }
}
