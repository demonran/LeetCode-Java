package com.lura.leetcode.problemset.linkedlist;

import com.lura.leetcode.problemset.struct.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * @ description: PalindromeLinkedList
 * @ author: Liu Ran
 * @ data: 5/7/23 11:10
 */
public class PalindromeLinkedList {

    private ListNode frontPointer;

    // 转换成数组链表
    public boolean isPalindrome(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i).val != list.get(list.size() - i - 1).val) {
                return false;
            }
        }
        return true;
    }

    /**
     * 递归对比
     */
    public boolean isPalindromeV2(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currNode) {
        if (currNode != null) {
            if (!recursivelyCheck(currNode.next)) {
                return false;
            }
            if (frontPointer.val != currNode.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;

    }

    /**
     * 双指针
     */
    public boolean isPalindromeV3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 找中间节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转列表
        ListNode secondHead = slow;
        ListNode pre = null;
        while (secondHead != null) {
            ListNode next = secondHead.next;
            secondHead.next = pre;
            pre = secondHead;
            secondHead = next;
        }
        secondHead = pre;

        //比对
        while (secondHead != null) {
            if (head.val != secondHead.val) {
                return false;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        return true;

    }


}
