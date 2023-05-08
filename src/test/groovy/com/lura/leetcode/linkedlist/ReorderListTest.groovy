package com.lura.leetcode.linkedlist

import com.lura.leetcode.struct.ListNodes
import spock.lang.Specification

/**
 * @ description: ReorderListTest
 * @ author: Liu Ran
 * @ data: 5/8/23 13:31
 */
class ReorderListTest extends Specification {
  var solution = new ReorderList()

  def "ReorderList"() {
    var actual = solution.reorderList(ListNodes.from(head))
    expect:
    ListNodes.toList(actual) == result;
    where:
    head            || result
    [1, 2, 3, 4]    || [1, 4, 2, 3]
    [1, 2, 3, 4, 5] || [1, 5, 2, 4, 3]
  }

  def "ReorderListV2"() {
    var actual = solution.reorderListV2(ListNodes.from(head))
    expect:
    ListNodes.toList(actual) == result;
    where:
    head            || result
    [1, 2, 3, 4]    || [1, 4, 2, 3]
    [1, 2, 3, 4, 5] || [1, 5, 2, 4, 3]
  }
}
