package com.lura.leetcode.lc.linked;

import com.lura.leetcode.struct.ListNode;

/**
 * Lc06TrainPlan5
 * 训练计划 V
 * 某教练同时带教两位学员，分别以链表 l1、l2 记录了两套核心肌群训练计划，节点值为训练项目编号。两套计划仅有前半部分热身项目不同，后续正式训练项目相同。请设计一个程序找出并返回第一个正式训练项目编号。如果两个链表不存在相交节点，返回 null 。
 *
 * @author Liu Ran
 */
public class Lc06TrainPlan5 {

    /**
     * 假设相同的节点为c a + (b -c) = b + (a-c) , 如果c = 0则没有相交。
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA: B.next;
        }
        return A;
    }

}
