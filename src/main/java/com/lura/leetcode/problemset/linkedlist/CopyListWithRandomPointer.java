package com.lura.leetcode.problemset.linkedlist;

import com.lura.leetcode.problemset.struct.Node;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 138. 复制带随机指针的链表
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 *
 * @ description: CopyListWithRandomPointer
 * @ author: Liu Ran
 * @ data: 5/8/23 12:58
 */
public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        Map<Node, Node> originToClone = new HashMap<>();

        for (Node p = head; p != null; p = p.next) {
            originToClone.put(p, new Node(p.val));
        }

        for (Node p = head; p != null; p = p.next) {
            if (p.next != null) {
                originToClone.get(p).next = originToClone.get(p.next);
            }
            if (p.random != null) {
                originToClone.get(p).random = originToClone.get(p.random);
            }
        }

        return originToClone.get(head);


    }


    Map<Node, Node> originToClone = new HashMap<>();
    /**
     * 递归算法
     */
    public Node copyRandomListV2(Node head) {
        traverse(head);
        return originToClone.get(head);
    }

    private void traverse(Node node) {
        if (node == null) {
            return;
        }

        if (!originToClone.containsKey(node)) {
            originToClone.put(node, new Node(node.val));
        }
        Node cloneNode = originToClone.get(node);

        traverse(node.next);

        if (node.next != null) {
            cloneNode.next = originToClone.get(node.next);
        }
        if (node.random != null) {
            cloneNode.random = originToClone.get(node.random);
        }

    }
}
