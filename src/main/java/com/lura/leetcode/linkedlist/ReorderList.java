package com.lura.leetcode.linkedlist;

import com.lura.leetcode.struct.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @ description: ReorderList
 * @ author: Liu Ran
 * @ data: 5/8/23 13:26
 */
public class ReorderList {
    public ListNode reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            // 避免中间节点重复处理
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        // 最后一个节点的下一个节点要置空，否则会死循环
        list.get(i).next = null;
        return head;
    }

    public ListNode reorderListV2(ListNode head) {
        // 找中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode midHead = slow.next;
        //断链，避免死循环
        slow.next = null;
        // 反转链表
        ListNode pre = null;
        while (midHead != null) {
            ListNode next = midHead.next;
            midHead.next = pre;
            pre = midHead;
            midHead = next;
        }

        //合并
        ListNode first = head;
        ListNode second = pre;
        while (first != null && second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            first = tmp1;
            second.next = tmp1;
            second = tmp2;
        }
        return head;
    }
}
