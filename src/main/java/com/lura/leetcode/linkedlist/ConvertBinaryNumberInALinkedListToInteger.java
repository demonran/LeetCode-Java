package com.lura.leetcode.linkedlist;

import com.lura.leetcode.struct.ListNode;

/**
 * 1290. 二进制链表转整数
 * 给你一个单链表的引用结点head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 *
 * @ description: ConvertBinaryNumberInALinkedListToInteger
 * @ author: Liu Ran
 * @ data: 5/15/23 13:16
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    int n = 0;

    /**
     * 后续遍历， 每次n+1。
     */
    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        int sum = getDecimalValue(head.next);
        return  sum + (int)(head.val * Math.pow(2, n++));
    }

    /**
     * 每次都当作是最后一位， 加下一位时把前一位*2在加当前位
     */
    private int getDecimalValueV2(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = ans * 2 + head.val;
            head = head.next;
        }
        return ans;
    }

    /**
     * 方法和V2相同， 采用位运算
     */
    private int getDecimalValueV3(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = ans << 1 | head.val;
            head = head.next;
        }
        return ans;
    }
}
