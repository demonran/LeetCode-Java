package com.lura.leetcode.top100;

import com.lura.leetcode.struct.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * CopyListWithRandomPointer
 *
 * @author Liu Ran
 */
public class CopyListWithRandomPointer {

    /**
     * 遍历复制， 遍历每个节点的时候都复制next和random
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        map.put(p, new Node(p.val));
        while (p != null) {
            // copy p.next
            if (p.next != null) {
                // 第一次出现的节点要保存到map中
                if (!map.containsKey(p.next)) {
                    map.put(p.next, new Node(p.next.val));
                }
                map.get(p).next = map.get(p.next);
            }
            // copy p.random
            if (p.random != null) {
                // 第一次出现的节点要保存到map中
                if (!map.containsKey(p.random)) {
                    map.put(p.random, new Node(p.random.val));
                }
                map.get(p).random = map.get(p.random);
            }
            p = p.next;
        }
        return map.get(head);
    }
}
