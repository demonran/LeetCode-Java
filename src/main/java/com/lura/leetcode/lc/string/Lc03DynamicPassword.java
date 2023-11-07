package com.lura.leetcode.lc.string;

/**
 * Lc02DynamicPassword
 * 动态口令
 * 某公司门禁密码使用动态口令技术。初始密码为字符串 password，密码更新均遵循以下步骤：
 *
 * 设定一个正整数目标值 target
 * 将 password 前 target 个字符按原顺序移动至字符串末尾
 * 请返回更新后的密码字符串。
 *
 * 输入: password = "s3cur1tyC0d3", target = 4
 * 输出: "r1tyC0d3s3cu"
 *
 * @author Liu Ran
 */
public class Lc03DynamicPassword {
    public String dynamicPassword(String password, int target) {
        int n = password.length();
        password = password + password;
        return password.substring(target, n + target);

    }
}
