package com.lura.leetcode.problemset.linkedlist;

import com.lura.leetcode.struct.ListNode;

/**
 * 23. 合并 K 个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;

        ListNode pre = new ListNode(-1);
        ListNode prev = pre;
        int minInx;
        boolean hasNode;
        do {
            hasNode = false;
            minInx = -1;
            for (int i = 0; i < n; i++) {
                ListNode list = lists[i];
                if (list == null) {
                    continue;
                }
                hasNode = true;
                if (prev.next == null || prev.next.val > list.val) {
                    prev.next = new ListNode(list.val);
                    minInx = i;
                }
            }
            if (minInx == -1) {
                break;
            }
            lists[minInx] = lists[minInx].next;
            prev = prev.next;

        } while (hasNode);

        return pre.next;

    }

    /**
     * 当作K-1个 合并两个链表处理。
     * @param lists
     * @return
     */
    public ListNode mergeKListsV2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode node = lists[0];
        for (int i = 1; i < lists.length; i++) {
            node = mergeTwoLists(node, lists[i]);
        }
        return node;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                tail.next = list2;
                list2 = list2.next;
            } else {
                tail.next = list1;
                list1 = list1.next;
            }
            tail = tail.next;
        }

        tail.next = list1 == null ? list2 : list1;
        return head.next;
    }
}
