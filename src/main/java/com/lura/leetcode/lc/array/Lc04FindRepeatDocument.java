package com.lura.leetcode.lc.array;

/**
 * Lc04FindRepeatDocument
 * 寻找文件副本
 * 设备中存有 n 个文件，文件 id 记于数组 documents。若文件 id 相同，则定义为该文件存在副本。请返回任一存在副本的文件 id。
 * @author Liu Ran
 */
public class Lc04FindRepeatDocument {

    /**
     * 存在n个文件， 说明文件一定是0-n之间
     * [2, 5, 3, 0, 5, 0]
     * @param documents
     * @return
     */
    public int findRepeatDocument(int[] documents) {
        for (int i = 0; i < documents.length; i++) {
            while (documents[i] != i) {
                if (documents[i] == documents[documents[i]]) {
                    return documents[i];
                }
                int tmp = documents[i];
                documents[i] = documents[tmp];
                documents[tmp] = tmp;
            }
        }
        return -1;
    }
}
