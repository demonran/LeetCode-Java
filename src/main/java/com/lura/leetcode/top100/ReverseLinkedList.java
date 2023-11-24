package com.lura.leetcode.top100;

import com.lura.leetcode.struct.ListNode;

/**
 * ReverseLinkedList
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @author Liu Ran
 */
public class ReverseLinkedList {

    /**
     * 递归反转， 后续遍历
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = reverseList(head.next);
        // 反转下一个节点的指针
        head.next.next = head;
        // 重置当前节点的下一个
        head.next = null;

        return tail;
    }

    /**
     * 遍历反转 [1,2,3,4,5]
     * @param head
     * @return
     */
    public ListNode reverseListV2(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            // 记录下一个节点
            ListNode next = head.next;
            // 反转当前节点
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
