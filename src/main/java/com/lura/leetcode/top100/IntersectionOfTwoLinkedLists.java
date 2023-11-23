package com.lura.leetcode.top100;

import com.lura.leetcode.struct.ListNode;

/**
 * IntersectionOfTwoLinkedLists
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * @author Liu Ran
 */
public class IntersectionOfTwoLinkedLists {

    /**
     *  走到列尾后接着遍历第二个队列， 有相交的话就会同时走到相同的节点，如果没有相交的话第二次会同时到达列尾。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return headA;
    }
}
