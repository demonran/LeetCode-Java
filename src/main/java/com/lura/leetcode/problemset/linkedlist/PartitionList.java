package com.lura.leetcode.problemset.linkedlist;

import com.lura.leetcode.struct.ListNode;

/**
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * @ description: PartitionList
 * @ author: Liu Ran
 * @ data: 5/15/23 13:36
 */
public class PartitionList {

    /**
     * 分成两个链表
     * 再把两个链表连起来
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallPrev = new ListNode(-1);
        ListNode bigPrev = new ListNode(-1);

        ListNode small = smallPrev;
        ListNode big = bigPrev;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = bigPrev.next;
        return smallPrev.next;
    }
}
