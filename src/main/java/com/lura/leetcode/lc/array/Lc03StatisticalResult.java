package com.lura.leetcode.lc.array;

/**
 * Lc03StatisticalResult
 * 按规则计算统计结果
 * 为了深入了解这些生物群体的生态特征，你们进行了大量的实地观察和数据采集。数组 arrayA 记录了各个生物群体数量数据，其中 arrayA[i] 表示第 i 个生物群体的数量。请返回一个数组 arrayB，该数组为基于数组 arrayA 中的数据计算得出的结果，其中 arrayB[i] 表示将第 i 个生物群体的数量从总体中排除后的其他数量的乘积。
 *
 * @author Liu Ran
 */
public class Lc03StatisticalResult {

    /**
     * 不能用除法，因为可能存在有一个数为0的情况
     *
     *      A[0] A[1] A[2] A[3] A[4]
     *  B[0]  1    3   4   5    6
     *  B[1]  2    1   4   5    6
     *  B[2]  2    3   1   5    6
     *  B[3]  2    3   4   1    6
     *  B[4]  2    3   4   5    1
     * @param arrayA
     * @return
     */
    public int[] statisticalResult(int[] arrayA) {
        // 长度为0直接返回
        if (arrayA.length == 0) {
            return new int[0];
        }
        // 定义结果
        int[] res = new int[arrayA.length];
        // res[i] 都相当于 *1
        res[0] = 1;
        for (int i = 1; i < arrayA.length; i++) {
            // 计算左下角
            res[i] = res[i - 1] * arrayA[i - 1];
        }
        int tmp = 1;
        for (int i = arrayA.length - 2; i >= 0; i--) {
            // 计算右上角
            tmp *= arrayA[i + 1];
            res[i] *=  tmp;
        }
        return res;
    }
}
