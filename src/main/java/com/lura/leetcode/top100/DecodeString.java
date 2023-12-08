package com.lura.leetcode.top100;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * DecodeString
 *
 * @author Liu Ran
 */
public class DecodeString {

    int ptr = 0;

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                String digit = getDigit(s);
                stack.push(digit);
            } else if (Character.isLetter(cur) || '[' == cur) {
                String item = String.valueOf(s.charAt(ptr));
                stack.push(item);
                ptr++;
            }else if(']' == cur){
                ptr++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peek())) {
                    sub.add(stack.pop());
                }
                // 删除左括号
                stack.pop();
                Collections.reverse(sub);

                int repeatCount = Integer.parseInt(stack.pop());

                StringBuilder sb = new StringBuilder();
                for (String s1 : sub) {
                    sb.append(s1);
                }
                stack.push(sb.toString().repeat(repeatCount));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    private String getDigit(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))) {
            sb.append(s.charAt(ptr));
            ptr++;
        }
        return sb.toString();
    }
}
