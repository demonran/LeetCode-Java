package com.lura.leetcode.top100

import com.lura.leetcode.struct.ListNodes
import spock.lang.Specification

/**
 * ReverseNodesInKGroupTest
 * @author Liu Ran
 */
class ReverseNodesInKGroupTest extends Specification {
  var solution = new ReverseNodesInKGroup()

  def "ReverseKGroup"() {
    expect:
    solution.reverseKGroup(head, k) == res
    where:
    head                            | k || res
    ListNodes.from([1, 2, 3, 4, 5]) | 3 || ListNodes.from([3, 2, 1, 4, 5])
  }
}
