package com.lura.leetcode.top100

import com.lura.leetcode.struct.TreeNodes
import spock.lang.Specification

/**
 * PathSum3Test
 * @author Liu Ran
 */
class PathSum3Test extends Specification {
  var solution = new PathSum3()

  def "PathSum"() {
    expect:
    solution.pathSum(root, target) == res
    where:
    root                                                                                                                | target || res
    TreeNodes.fromList([1000000000, 1000000000, null, 294967296, null, 1000000000, null, 1000000000, null, 1000000000]) | 0      || 0
  }
}
