package com.lura.leetcode.datastructure;

import com.lura.leetcode.struct.ListNode;

/**
 * 705. 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * 实现 MyHashSet 类：
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * @ description: DesignHashset
 * @ author: Liu Ran
 * @ data: 5/10/23 12:55
 */
public class DesignHashset {


}

/**
 *   长数组方法
 */
class MyHashSet {
    boolean[] list;

    public MyHashSet() {
        list = new boolean[1000001];
    }

    public void add(int key) {
        list[key] = true;
    }

    public void remove(int key) {
        list[key] = false;
    }

    public boolean contains(int key) {
        return list[key];
    }
}

/**
 * 使用bitmap.
 */
class MyHashSetV2 {
    int[] bs;

    public MyHashSetV2() {
        //最大是10^6 , 一个int 4 byte , 1byte=8bit
        // 40000 * 4 * 8 = 1280000
        bs = new int[40000];
    }

    public void add(int key) {
        int bucket = key / 32;
        int loc = key % 32;
        setVal(bucket, loc, true);
    }

    public void remove(int key) {
        int bucket = key / 32;
        int loc = key % 32;
        setVal(bucket, loc, false);
    }

    public boolean contains(int key) {
        int bucket = key / 32;
        int loc = key % 32;
        return ((bs[bucket] >> loc) & 1) == 1;
    }

    private void setVal(int bucket, int loc, boolean val) {
        if (val) {
            bs[bucket] |= 1 << loc;
        } else {
            bs[bucket] &= ~(1 << loc);
        }
    }
}

/**
 * 链表方法
 */
class MyHashSetV3 {
    ListNode[] nodes ;

    public MyHashSetV3() {
        nodes = new ListNode[1000];
    }

    public void add(int key) {
        int index = key % nodes.length;
        ListNode loc = nodes[index];
        while (loc != null) {
            if (loc.val == key) {
                return;
            }
            loc = loc.next;
        }
        ListNode node = new ListNode(key);
        node.next = nodes[index];
        nodes[index] = node;
    }

    public void remove(int key) {
        int index = key % nodes.length;
        ListNode loc = nodes[index];
        ListNode pre = null;
        while (loc != null) {
            if (loc.val == key) {
                if (pre == null) {
                    nodes[index] = loc.next;
                }else {
                    pre.next = loc.next;
                }
                return;
            }
            pre = loc;
            loc = loc.next;
        }
    }

    public boolean contains(int key) {
        int index = key % nodes.length;
        ListNode loc = nodes[index];
        while (loc != null) {
            if (loc.val == key) {
                return true;
            }
            loc = loc.next;
        }
        return false;
    }

}
