package com.lura.leetcode.linkedlist

import com.lura.leetcode.problemset.linkedlist.SwapNodesInPairs
import com.lura.leetcode.problemset.struct.ListNodes
import spock.lang.Specification

/**
 * @ description: SwapNodesInPairsTest
 * @ author: Liu Ran
 * @ data: 5/4/23 13:08
 */
class SwapNodesInPairsTest extends Specification {

  var solution = new SwapNodesInPairs()

  def "SwapPairs"() {
    expect:
    solution.swapPairs(ListNodes.from(head)) == ListNodes.from(result)
    where:
    head         || result
    [1, 2, 3, 4] || [2, 1, 4, 3]
  }
}
