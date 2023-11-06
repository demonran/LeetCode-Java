package com.lura.leetcode.lc.linked;

import com.lura.leetcode.struct.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Lc01_book
 *
 * 图书整理 I
 * 书店店员有一张链表形式的书单，每个节点代表一本书，节点中的值表示书的编号。为更方便整理书架，店员需要将书单倒过来排列，就可以从最后一本书开始整理，逐一将书放回到书架上。请倒序返回这个书单链表。
 *
 *
 * @author Liu Ran
 */
public class Lc01Book {

    /**
     * 反转链表
     * 方法一： 递归反转
     * @param head
     * @return
     */
    List<Integer> res = new ArrayList<>();
    public int[] reverseBookList(ListNode head) {

        reverse(head);
        // List转换成array
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;

    }

    private void reverse(ListNode head) {
        // 空列表说明到达队尾
        if (head == null) {
            return;
        }
        // 递归
        reverse(head.next);
        // 后续遍历
        res.add(head.val);
    }

    /**
     * 方法二： 使用栈实现
     * @param head
     * @return
     */
    public int[] reverseBookListV2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] arr = new int[stack.size()];
        int i =0;
        while (!stack.isEmpty()) {
            arr[i++] = stack.pop();
        }
        return arr;
    }

}
