package com.lura.leetcode.linkedlist

import com.lura.leetcode.struct.ListNodeFactory
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
    solution.swapPairs(ListNodeFactory.from(head)) == ListNodeFactory.from(result)
    where:
    head         || result
    [1, 2, 3, 4] || [2, 1, 4, 3]
  }
}
