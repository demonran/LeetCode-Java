package com.lura.leetcode.problemset.graph

import com.lura.leetcode.problemset.graph.AllPathsFromSourceToTarget
import spock.lang.Specification

/**
 * @ description: AllPathsFromSourceToTargetTest
 * @ author: Liu Ran
 * @ data: 4/28/23 13:33
 */
class AllPathsFromSourceToTargetSpec extends Specification {

  var solution = new AllPathsFromSourceToTarget();

  def "AllPathsSourceTarget"() {
    expect:
      solution.allPathsSourceTarget(graph) == path
    where:
    graph || path
    [[1,2],[3],[3],[]] as int[][] || [[0,1,3],[0,2,3]]
    [[4,3,1],[3,2,4],[3],[4],[]] as int[][] || [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
  }
}
