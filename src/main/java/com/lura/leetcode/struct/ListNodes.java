package com.lura.leetcode.struct;

public class ListNodes {

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
