package com.lura.leetcode.linkedlist;

import com.lura.leetcode.struct.ListNode;

/**
 * 面试题 02.06. 回文链表
 * 编写一个函数，检查输入的链表是否是回文的。
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @ description: PalindromeLinkedListLcci
 * @ author: Liu Ran
 * @ data: 5/13/23 10:02
 */
public class PalindromeLinkedListLcci {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pre = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        while (pre != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;


    }
}
