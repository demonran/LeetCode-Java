package com.lura.leetcode.lc.linked;

import com.lura.leetcode.struct.ListNode;

/**
 * Lc02DeleteLinked
 * 删除链表节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 *
 * @author Liu Ran
 */
public class Lc02DeleteLinked {

    public ListNode deleteNode(ListNode head, int val) {
        // 虚拟一个头节点，保证删除头节点和其他节点逻辑统一
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 创建一个curr, 指向dummy， 保留dummy的指针
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                // 如何找到要删除的值，则直接将当前node指向下一个节点的下一个节点。
                curr.next = curr.next.next;
            } else {
                // 正常往后遍历
                curr = curr.next;
            }
        }
        // 返回虚拟头节点的下一个节点
        return dummy.next;
    }
}
