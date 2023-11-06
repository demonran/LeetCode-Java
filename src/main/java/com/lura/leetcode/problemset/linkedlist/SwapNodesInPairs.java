package com.lura.leetcode.problemset.linkedlist;

import com.lura.leetcode.struct.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * @ description: SwapNodesInPairs
 * @ author: Liu Ran
 * @ data: 5/4/23 13:01
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(-1, head);
        ListNode cur = pre;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next;

            //交换
            cur.next = cur.next.next;
            next.next = cur.next.next;
            cur.next.next = next;

            // 移动指针
            cur = next;
        }
        return pre.next;

    }
}
