package com.lura.leetcode.problemset.linkedlist;

import com.lura.leetcode.struct.ListNode;

import java.math.BigInteger;

/**
 * 2. 两数相加
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 */
public class AddTwoNumbers {

    // 先算出num1 和num2 在求和，在转化成LinkedNode ， 会有精度问题
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = BigInteger.valueOf(0), num2 = BigInteger.valueOf(0);
        int i = 0;
        while (l1 != null) {
            num1 = num1.add(BigInteger.valueOf((long) (l1.val * Math.pow(10, i))));
            l1 = l1.next;
            i++;
        }

        i = 0;
        while (l2 != null) {
            num2 = num2.add(BigInteger.valueOf((long) (l2.val * Math.pow(10, i))));
            l2 = l2.next;
            i++;
        }

        BigInteger sum = num1.add(num2);
        if (sum.equals(BigInteger.ZERO)) {
            return new ListNode(0);
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode head = new ListNode(sum.mod(BigInteger.valueOf(10)).intValue());
        dummyNode.next = head;

        sum = sum.divide(BigInteger.valueOf(10));
        while (!sum.equals(BigInteger.ZERO)) {
            head.next = new ListNode((sum.mod(BigInteger.valueOf(10)).intValue()));
            head = head.next;
            sum = sum.divide(BigInteger.valueOf(10));
        }
        return dummyNode.next;
    }

    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return dummyNode.next;
    }

}
