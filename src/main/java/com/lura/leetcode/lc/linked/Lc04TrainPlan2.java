package com.lura.leetcode.lc.linked;

import com.lura.leetcode.struct.ListNode;

/**
 * Lc04TrainPlan2
 * 训练计划 II
 * 给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号。
 * @author Liu Ran
 */
public class Lc04TrainPlan2 {

    /**
     * 快慢指针
     * @param head
     * @param cnt
     * @return
     */
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < cnt; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
