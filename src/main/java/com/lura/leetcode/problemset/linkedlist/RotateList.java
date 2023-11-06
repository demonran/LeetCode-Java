package com.lura.leetcode.problemset.linkedlist;

import com.lura.leetcode.problemset.struct.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * @ description: RotateList
 * @ author: Liu Ran
 * @ data: 5/4/23 19:51
 */
public class RotateList {

    //使用双向队列
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            stack.addLast(cur);
            cur = cur.next;
        }

        int n = stack.size();

        // 如果k是n的整数倍，则相当于没有变化
        if ( k % n == 0) {
            return head;
        }

        // k > n 时， 移动 k % n即可, 旋转次数。
        k = k % n;

        for (int i = 0; i < k; i++) {
            cur = stack.pollLast();
            stack.addFirst(cur);
            cur.next = head;
            head = cur;
        }
        // 断链
        stack.getLast().next = null;

        return head;
    }

    // 先连成环， 再到制定位置断开
    public ListNode rotateRightV2(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // 计算总长度， 并找到最后一个节点
        int n = 1;
        ListNode cur = head;
        while (cur.next != null) {
            n++;
            cur = cur.next;
        }

        // 如果k是n的整数倍，则相当于没有变化
        if ( k % n == 0) {
            return head;
        }
        //断链位置
        int p = n - k % n;

        // 成环
        cur.next = head;

        while (p-- > 0) {
            cur = cur.next;
        }
        // 断链
        head = cur.next;
        cur.next = null;
        return head;

    }
}
