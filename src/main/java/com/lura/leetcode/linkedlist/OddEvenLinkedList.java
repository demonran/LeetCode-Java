package com.lura.leetcode.linkedlist;

import com.lura.leetcode.struct.ListNode;

/**
 * 328. 奇偶链表
 * 给定单链表的头节点head，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在O(1)的额外空间复杂度和O(n)的时间复杂度下解决这个问题。
 *
 * @ description: OddEvenLinkedList
 * @ author: Liu Ran
 * @ data: 5/5/23 18:38
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {



        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;

        while (even!= null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
