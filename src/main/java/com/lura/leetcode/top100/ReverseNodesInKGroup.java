package com.lura.leetcode.top100;

import com.lura.leetcode.struct.ListNode;

/**
 * ReverseNodesInKGroup
 * 25. K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @author Liu Ran
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        // 找到第k+1个节点
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if (end == null) {
                return head;
            }
            end = end.next;
        }
        // 反转k个节点[head, end)
        ListNode pre = null;
        ListNode curr = head;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        // head变为最后一个节点， head连接下一组节点的头
        head.next = reverseKGroup(curr, k);
        // 返回头节点
        return pre;
    }
}
