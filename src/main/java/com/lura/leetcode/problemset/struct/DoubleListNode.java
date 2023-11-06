package com.lura.leetcode.problemset.struct;

public class DoubleListNode {
    public int val;
    public DoubleListNode next;
    public DoubleListNode prev;

    public DoubleListNode(int val) {
        this.val = val;
    }

    public DoubleListNode(int val, DoubleListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "";
    }


}
