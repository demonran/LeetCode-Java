package com.lura.leetcode.problemset.linkedlist;

import com.lura.leetcode.struct.ListNode;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * @ description: SortList
 * @ author: Liu Ran
 * @ data: 5/9/23 10:20
 */
public class SortList {

    // 冒泡排序，会超时
    public ListNode sortList(ListNode head) {
        ListNode pre = new ListNode(Integer.MIN_VALUE, head);
        ListNode last = null;

        while (last != pre.next) {
            ListNode cur = pre;
            while (cur.next != null && cur.next.next != last) {
                if (cur.next.val > cur.next.next.val ) {
                    ListNode next = cur.next;

                    cur.next = next.next;
                    next.next = cur.next.next;
                    cur.next.next = next;
                }
                cur = cur.next;
            }
            last = cur.next;
        }
        return pre.next;
    }

    /**
     * 归并排序（递归）
     * 1. 先分成两个链表
     * 2. 分别递归排序
     * 3. 合并链表
     */
    public ListNode sortListV2(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode n1 = sortList(head, slow);
        ListNode n2 = sortList(slow, tail);
        return merge(n1, n2);

    }

    private ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        if (n1.val < n2.val) {
            n1.next = merge(n1.next, n2);
            return n1;
        }else {
            n2.next = merge(n1, n2.next);
            return n2;
        }
    }
}
