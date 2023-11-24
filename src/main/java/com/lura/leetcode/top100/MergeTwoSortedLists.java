package com.lura.leetcode.top100;

import com.lura.leetcode.struct.ListNode;

/**
 * MergeTwoSortedLists
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author Liu Ran
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 定义一个临时头节点
        ListNode pre = new ListNode(-1);
        // 当前指针
        ListNode curr = pre;
        while (list1 != null && list2 != null) {
            // 哪个小就挂在curr的next
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            }else {
                curr.next = list2;
                list2 = list2.next;
            }
            // 移动curr
            curr = curr.next;
        }
        // 另一个非空的节点直接挂在curr后面。
        curr.next = list1 == null ? list2 : list1;
        return pre.next;
    }
}
