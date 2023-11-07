package com.lura.leetcode.lc.string;

/**
 * Lc02ReverseMessage
 * 字符串中的单词反转
 * 你在与一位习惯从右往左阅读的朋友发消息，他发出的文字顺序都与正常相反但单词内容正确，为了和他顺利交流你决定写一个转换程序，把他所发的消息 message 转换为正常语序。
 *
 * 注意：输入字符串 message 中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * @author Liu Ran
 */
public class Lc02ReverseMessage {

    /**
     * 输入: message = "the sky is blue"
     * 输出: "blue is sky the"
     *
     * 双指针
     * @param message
     * @return
     */
    public String reverseMessage(String message) {
        message = message.trim();
        int i = message.length() - 1, j = message.length() - 1;
        StringBuilder ans = new StringBuilder();
        while (i >=0) {
            // 找到单词的第一个字符
            while (i >= 0 && message.charAt(i) != ' ') i--;
            // 写入单词， i 在单词前面的空格， j在单词最后一个字符，所以都需要+1
            ans.append(message, i + 1, j + 1).append(" ");
            // 找到单词的最后一个字符
            while (i > 0 && message.charAt(i) == ' ') i--;
            j = i;
        }
        // 去除最后一个空格
        return ans.toString().trim();
     }
}
