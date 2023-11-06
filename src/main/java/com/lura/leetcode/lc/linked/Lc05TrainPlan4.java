package com.lura.leetcode.lc.linked;

import com.lura.leetcode.struct.ListNode;

/**
 * Lc05TrainPlan4
 * 训练计划 IV
 * 给定两个以 有序链表 形式记录的训练计划 l1、l2，分别记录了两套核心肌群训练项目编号，请合并这两个训练计划，按训练项目编号 升序 记录于链表并返回。
 *
 * 注意：新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author Liu Ran
 */
public class Lc05TrainPlan4 {
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        // 虚拟头节点，用于最后返回使用
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        // 如果都不为null，则往下遍历
        while (l1 != null && l2 != null) {
            // 哪个小就后移哪个链表
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // 跳出循环时一定有一个链表遍历到最后了，所以把另外一个节点追加到当前链表的尾部即可。
        if (l1 == null) {
          curr.next = l2;
        }else {
            curr.next = l1;
        }
        return dummy.next;
    }
}
