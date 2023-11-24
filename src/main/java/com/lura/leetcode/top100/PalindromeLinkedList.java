package com.lura.leetcode.top100;

import com.lura.leetcode.struct.ListNode;

/**
 * PalindromeLinkedList
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * @author Liu Ran
 */
public class PalindromeLinkedList {

    ListNode frontPointer;

    /**
     * 递归方法，对比第一个和最后一个节点，
     * 最后一个节点反向出栈， 第一个节点向后移动
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return isSame(head);
    }

    private boolean isSame(ListNode head) {
        if (head != null) {
            // 递归走到最后一个节点，下一个节点不想等，则直接返回false
            if (!isSame(head.next)) {
                return false;
            }
            // 判断前后两个节点是否相等
            if (frontPointer.val != head.val) {
                return false;
            }
            frontPointer = frontPointer.next;

        }
        return true;
    }


    /**
     * 双指针
     * @param head
     * @return
     */
    public boolean isPalindromeV2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;

    }

    private ListNode reverse(ListNode head) {
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
