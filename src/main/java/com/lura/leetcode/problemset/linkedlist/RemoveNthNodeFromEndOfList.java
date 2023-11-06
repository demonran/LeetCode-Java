package com.lura.leetcode.problemset.linkedlist;

import com.lura.leetcode.problemset.struct.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthNodeFromEndOfList {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        ListNode cur = dummy;

        for (int i = 0; i < length - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;

        Deque<ListNode> stack = new LinkedList<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;

    }

    /*
    双指针， 快指针先走n步， 然后快慢指针一起走， 当快指针到链表尾时则满指针刚好到倒数n。
     */
    public ListNode removeNthFromEndV3(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode first = head;
        ListNode secend = dummy;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            secend = secend.next;
        }

        secend.next = secend.next.next;
        return dummy.next;

    }
}
