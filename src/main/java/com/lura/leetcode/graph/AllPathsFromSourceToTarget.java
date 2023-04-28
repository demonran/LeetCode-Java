package com.lura.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 797. 所有可能的路径
 *给你一个有n个节点的 有向无环图（DAG），请你找出所有从节点 0到节点 n-1的路径并输出（不要求按特定顺序）
 * graph[i]是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点graph[i][j]存在一条有向边）。
 *
 * @ description: AllPathsFromSourceToTarget
 * @ author: Liu Ran
 * @ data: 4/28/23 13:17
 */
public class AllPathsFromSourceToTarget {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        traverse(graph, 0, new LinkedList<>());
        return res;
    }

    // 在for循环外面处理， 目的是为了处理根节点。 在循环内部遍历会缺少根节点
    private void traverse(int[][] graph, int i, LinkedList<Integer> path) {
        // 在for循环外面处理， 目的是为了处理根节点。 在循环内部遍历会缺少根节点
        path.add(i);

        // 到达target , target = graph.length - 1
        if (i == graph.length - 1) {
            res.add(new LinkedList<>(path));
            // 此处也需要回溯，因为直接return了
            path.removeLast();
            return;
        }

        for (int j = 0; j < graph[i].length; j++) {
            traverse(graph, graph[i][j], path);
        }
        path.removeLast();
    }

}
