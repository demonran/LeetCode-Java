package com.lura.leetcode.problemset.linkedlist;

import com.lura.leetcode.struct.ListNode;

/**
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @ description: IntersectionOfTwoLinkedLists
 * @ author: Liu Ran
 * @ data: 5/6/23 20:03
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode cur = headB;
            while (cur != null) {
                if (headA == cur) {
                    return headA;
                }
                cur = cur.next;
            }
            headA = headA.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        //找不到时p1 和p2都为null， 也会跳出循环
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;

        }
        return p1;
    }
}
