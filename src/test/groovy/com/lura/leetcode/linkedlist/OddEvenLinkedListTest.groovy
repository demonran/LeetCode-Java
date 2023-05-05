package com.lura.leetcode.linkedlist

import com.lura.leetcode.struct.ListNodes
import spock.lang.Specification

/**
 * @ description: OddEvenLinkedListTest
 * @ author: Liu Ran
 * @ data: 5/5/23 18:54
 */
class OddEvenLinkedListTest extends Specification {
  var solution = new OddEvenLinkedList()

  def "OddEvenList"() {
    expect:
    solution.oddEvenList(ListNodes.from(head)) == ListNodes.from(result)
    where:
    head                  || result
    [1, 2, 3, 4, 5]       || [1, 3, 5, 2, 4]
    [2, 1, 3, 5, 6, 4, 7] || [2, 3, 6, 7, 1, 5, 4]
  }
}
