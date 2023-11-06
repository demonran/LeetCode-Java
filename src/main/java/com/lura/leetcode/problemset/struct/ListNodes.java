package com.lura.leetcode.problemset.struct;

import java.util.LinkedList;
import java.util.List;

public class ListNodes {

    public static ListNode from(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        if (arr.length == 1) {
            return new ListNode(arr[0]);
        }

        ListNode head = new ListNode(arr[0]);
        ListNode next = new ListNode(arr[1]);
        head.next = next;
        for (int i = 2; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            next.next = node;
            next = node;
        }
        return head;
    }

    public static ListNode from(List<Integer> list) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        for (Integer val : list) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return pre.next;
    }


    public static ListNode[] from(int[][] nodes) {
        ListNode[] lists = new ListNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {

            int[] arr = nodes[i];
            if (arr.length == 0) {
                continue;
            }
            if (arr.length == 1) {
                lists[i] = new ListNode(arr[0]);
                continue;
            }

            ListNode head = new ListNode(arr[0]);
            ListNode next = new ListNode(arr[1]);
            head.next = next;
            for (int j = 2; j < arr.length; j++) {
                ListNode node = new ListNode(arr[j]);
                next.next = node;
                next = node;
            }
            lists[i] = head;
        }

        return lists;

    }

    public static List<Integer> toList(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }


    public static boolean equals(ListNode n1, ListNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        return n1.val == n2.val && equals(n1.next, n2.next);
    }

    public static boolean equalsV2(ListNode n1, ListNode n2) {

        while (n1 != null || n2 != null) {
            if (n1 == null || n2 == null) {
                return false;
            }
            if (n1.val != n2.val) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        return true;
    }


}
