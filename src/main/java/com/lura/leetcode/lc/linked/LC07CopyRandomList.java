package com.lura.leetcode.lc.linked;

import com.lura.leetcode.struct.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * LC07CopyRandomList
 *随机链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * @author Liu Ran
 */
public class LC07CopyRandomList {

    /**
     * 方法一： 散列表存储
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        // 将当前节点和新节点对应关系存储在map中
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            // map.get(curr) ：copy的节点
            // 给copy的节点赋值
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    /**
     * 链表拼接，把新节点插入到老节点后面
     * @param head
     * @return
     */
    public Node copyRandomListV2(Node head) {
        // 判null，防止第三步空指针
        if(head == null) {
            return null;
        }
        // 拼接， 新老节点拼接
        Node curr = head;
        while (curr != null) {
            Node tmp = new Node(curr.val);
            tmp.next = curr.next;
            curr.next = tmp;
            curr = tmp.next;
        }

        // 构建，新节点增加random
        curr = head;
        while (curr != null) {
            // 给新节点random赋值， curr.random 为老节点random， 老节点的next是新节点。 random不需要new.
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // 拆分
        curr = head.next;
        Node res = head.next;
        // pre是为了还原源链表。
        Node pre = head;
        while (curr.next != null) {
            pre.next = pre.next.next;
            curr.next = curr.next.next;
            pre = pre.next;
            curr = curr.next;
        }
        // 处理最后一个节点的尾节点为null
        pre.next = null;
        return res;


    }


}
