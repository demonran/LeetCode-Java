package com.lura.leetcode.top100;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * FirstMissPositive
 *
 * @author Liu Ran
 */
public class FirstMissPositive {
    /**
     * 哈希表解法， 先放入hash表中，然后从1开始找。
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int i = 1;
        while (true) {
            if (!set.contains(i)) {
                return i;
            }
            i++;
        }
    }

    /**
     * 数组长度为N， 结果一定是[1,N+1]之间
     * 我们把[1,N+1]之外的数设置为N+1
     * 然后把[1, N]下标对应的数据改为负数
     * 那么第一个正数的下标+1就是结果， 因为[1, N]对应的下标都设置成-1负数了，  没有设置的就是不存在的结果。
     * @param nums
     * @return
     */
    public int firstMissingPositiveV2(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > n || nums[i] < 1) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            // 取绝对值，因为有可能被改成了负数
            int num = Math.abs(nums[i]);
            if (num <= n) {
                // 用绝对值，避免两次修改同一个位置数据，如[1,1]
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i+1;
            }
        }
        return n + 1;
    }
}
