package com.lura.leetcode.datastructure;

import java.util.Arrays;

/**
 * 706. 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * 实现 MyHashMap 类：
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *
 * @ description: DesignHashmap
 * @ author: Liu Ran
 * @ data: 5/10/23 19:01
 */
public class DesignHashmap {
}

class Node {
    int key;
    int val;
    Node next;
}

class MyHashMap {

    int[] nodes;
    public MyHashMap() {
        nodes = new int[1000001];
        Arrays.fill(nodes, -1);
    }

    public void put(int key, int value) {
        nodes[key] = value;
    }

    public int get(int key) {
        return nodes[key];
    }

    public void remove(int key) {
        nodes[key] = -1;
    }
}
