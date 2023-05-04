package com.lura.leetcode.linkedlist;

import com.lura.leetcode.struct.ListNode;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 */
public class ReverseLinkedList2 {

    // 1 -> 2 -> 3 -> 4 -> 5
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 虚拟出来一个节点作为head节点，避免各种情况讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1 && pre != null; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        for (int i = left; i < right && cur != null; i++) {
            ListNode next = cur.next;
            // 前端节点连接到下一个节点的子节点
            cur.next = next.next;
            // 后面的节点插入到pre之后
            next.next = pre.next;
            pre.next = next;

        }

        return dummyNode.next;

    }

}
