package com.lura.leetcode.lc.linked;

import com.lura.leetcode.struct.ListNode;

/**
 * Lc03TrainPlan
 * 训练计划 III
 * 给定一个头节点为 head 的单链表用于记录一系列核心肌群训练编号，请将该系列训练编号 倒序 记录于链表并返回。
 * @author Liu Ran
 */
public class Lc03TrainPlan3 {

    /**
     * 方法一： 递归
     * @param head
     * @return
     */
    public ListNode trainningPlan(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = trainningPlan(head.next);
        // 反转逻辑
        head.next.next = head;
        // 设置当前节点的next为null
        head.next = null;
        return res;
    }

    /**
     * 方法二： 线性反转
     * @param head
     * @return
     */
    public ListNode trainningPlanV2(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            // 暂存下一个节点
            ListNode next = head.next;
            // 反转逻辑
            head.next = pre;
            // 暂存当前节点
            pre = head;
            // 访问下一个节点
            head = next;
        }
        return pre;
    }
}
