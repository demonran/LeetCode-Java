package com.lura.leetcode.linkedlist;

import com.lura.leetcode.struct.ListNode;

/**
 * @ description: DesignHashset
 * @ author: Liu Ran
 * @ data: 5/9/23 19:04
 */
public class DesignHashset {

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // 返回 True
        System.out.println(myHashSet.contains(3)); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // 返回 True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // 返回 False ，（已移除）

    }

}

// 纯链表实现
class MyHashSet{

    private ListNode head;

    public MyHashSet() {
        head = new ListNode(Integer.MIN_VALUE);
    }

    public void add(int key) {
        ListNode cur = head;
        ListNode toAdd = new ListNode(key);
        while (cur.next != null) {
            if (cur.next.val > key) {
                cur.next = toAdd;
                toAdd.next = cur.next;
                return;
            } else if (cur.next.val == key) {
                return;
            }
            cur = cur.next;
        }
        cur.next = toAdd;
    }

    public void remove(int key) {
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }

    public boolean contains(int key) {
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}
