package com.lura.leetcode.linkedlist;

import com.lura.leetcode.struct.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        while (head != null) {
            ListNode next = head.next;
            if (next == null) {
                break;
            }
            if (head.val == next.val) {
                head.next = next.next;
            }else {
                head = head.next;
            }

        }
        return dummy.next;
    }
}
