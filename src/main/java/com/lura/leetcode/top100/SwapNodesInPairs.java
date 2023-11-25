package com.lura.leetcode.top100;

import com.lura.leetcode.struct.ListNode;

/**
 * SwapNodesInPairs
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * @author Liu Ran
 */
public class SwapNodesInPairs {

    /**
     * 遍历解法： [1,2,3,4]
     *  同时保存三个元素： curr(0),  curr.next(1) , curr.next.next(2)
     *  0 -> 1 -> 2 -> 3
     *  0 -> 2 -> 3 (2)
     *  1 -> 3 (0 -> 2)
     *  (0 -> 2) -> (1 -> 3)
     *  0 == 1
     *
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            // 记录第一个元素
            ListNode next = curr.next;
            // 交换元素
            curr.next = next.next;
            next.next = curr.next.next;
            curr.next.next = next;
            // 移动当前指针
            curr = next;
        }
        return dummy.next;
    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode swapPairsV2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        ListNode third = head.next.next;

        // 交换first 和 second
        second.next = first;
        // first.next = 下一个头元素
        first.next = swapPairsV2(third);
        // 返回交换后的头元素
        return second;
    }
}
