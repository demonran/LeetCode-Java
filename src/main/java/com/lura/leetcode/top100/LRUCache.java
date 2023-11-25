package com.lura.leetcode.top100;

import java.util.LinkedHashMap;

/**
 * LruCache
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * @author Liu Ran
 */
public class LRUCache {

    private final int capacity;

    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            makeRecently(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            makeRecently(key);
            return;
        }
        if (map.size() == capacity) {
            Integer first = map.keySet().iterator().next();
            map.remove(first);
        }
        map.put(key, value);
    }

    /**
     * 核心方法，实现将元素添加到队尾
     * @param key
     */
    private void makeRecently(int key) {
        Integer value = map.remove(key);
        map.put(key, value);
    }
}
