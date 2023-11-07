package com.lura.leetcode.lc.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Lc02FileCombination
 * 文件组合
 * 待传输文件被切分成多个部分，按照原排列顺序，每部分文件编号均为一个 正整数（至少含有两个文件）。传输要求为：连续文件编号总和为接收方指定数字 target 的所有文件。请返回所有符合该要求的文件传输组合列表。
 * 注意，返回时需遵循以下规则：
 * 每种组合按照文件编号 升序 排列；
 * 不同组合按照第一个文件编号 升序 排列。
 *
 * @author Liu Ran
 */
public class Lc02FileCombination {
    public int[][] fileCombination(int target) {
        // 定义左右边界和总和
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        // 左边界 < 右边界
        while (i < j) {
            // 找到目标数据后
            if (s == target) {
                // 组装数据
                int[] arr = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
            }
            if (s <= target) {
                // 小于目标时，扩大右边界
                j++;  // 先加后减，闭区间
                s += j;
            } else {
                // 大于目标时，增加左边界， 即较少数组长度
                s -= i; // 先减后加
                i++;
            }
        }
        return res.toArray(new int[0][]);
    }

}
