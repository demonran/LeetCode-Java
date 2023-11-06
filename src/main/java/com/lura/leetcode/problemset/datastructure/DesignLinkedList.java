package com.lura.leetcode.problemset.datastructure;

import com.lura.leetcode.struct.DoubleListNode;
import com.lura.leetcode.struct.ListNode;

/**
 * 707. 设计链表
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
 *
 * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 *
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
 *
 * 实现 MyLinkedList 类：
 *
 * MyLinkedList() 初始化 MyLinkedList 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 *
 * @ description: DesignLinkedList
 * @ author: Liu Ran
 * @ data: 5/19/23 13:07
 */
public class DesignLinkedList {

}

class MyLinkedList {

    ListNode head;
    int size;

    public MyLinkedList() {
        head = new ListNode(-1);
        size = 0;
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        ListNode curr = head;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        ListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        ListNode node = new ListNode(val);
        node.next = curr.next;
        curr.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        ListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        size--;
    }
}


class MyLinkedListV2 {

    DoubleListNode head, tail;
    int size;

    public MyLinkedListV2() {
        head = new DoubleListNode(-1);
        tail = new DoubleListNode(-1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        DoubleListNode curr = getNode(index);
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return ;
        }
        DoubleListNode succ = getNode(index);

        DoubleListNode node = new DoubleListNode(val);
        node.prev = succ.prev;
        node.next = succ;
        succ.prev.next = node;
        succ.prev = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return ;
        }
        DoubleListNode succ = getNode(index);
        succ.prev.next = succ.next;
        succ.next.prev = succ.prev;
        size--;
    }

    private DoubleListNode getNode(int index) {
        DoubleListNode curr = head;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr;
    }
}
