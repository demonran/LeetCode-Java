package com.lura.leetcode.problemset.linkedlist


import com.lura.leetcode.struct.ListNodes
import spock.lang.Specification

/**
 * @ description: InsertionSortListTest
 * @ author: Liu Ran
 * @ data: 5/17/23 13:20
 */
class InsertionSortListTest extends Specification {
  var solution = new InsertionSortList()

  def "InsertionSortList"() {
    def actual = solution.insertionSortList(ListNodes.from(head))
    expect:
    ListNodes.toList(actual) == res
    where:
    head         || res
    [4, 2, 1, 3] || [1, 2, 3, 4]
    [1, 1]       || [1, 1]
  }
}
