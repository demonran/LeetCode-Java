package com.lura.leetcode.struct;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "";
    }

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

    public static List<Integer> toList(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return ListNodes.equals(this, (ListNode) o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
