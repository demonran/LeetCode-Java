package com.lura.leetcode.graph

import com.lura.leetcode.problemset.graph.IsGraphBipartite
import spock.lang.Specification

/**
 * @ description: IsGraphBipartiteSpec
 * @ author: Liu Ran
 * @ data: 4/28/23 14:19
 */
class IsGraphBipartiteSpec extends Specification {
  var solution = new IsGraphBipartite()

  def "IsBipartite"() {
    expect:
    solution.isBipartite(graph) == ok
    where:
    graph                                           || ok
    [[1, 2, 3], [0, 2], [0, 1, 3], [0, 2]] as int[][] || false
    [[1, 3], [0, 2], [1, 3], [0, 2]] as int[][]       || true

  }
}
