package com.lura.leetcode.top100;

import com.lura.leetcode.struct.ListNode;

/**
 * LinkedListCycle2
 * 142. 环形链表 II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 * @author Liu Ran
 */
public class LinkedListCycle2 {

    /**
     * 1. 先找到相遇点。
     * 2. 找到交点后，将其中一个指针从头开始，并行走，再次相遇的地方就是交点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 相遇
            if (fast == slow) {
                break;
            }
        }
        // 如果是非相遇退出，则没有交点
        if (fast == null || fast.next == null) {
            return null;
        }
        // 将快指针指向head
        fast = head;
        // 再次相遇即为交点
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
