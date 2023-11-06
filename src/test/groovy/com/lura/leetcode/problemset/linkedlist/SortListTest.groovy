package com.lura.leetcode.problemset.linkedlist


import com.lura.leetcode.struct.ListNodes
import spock.lang.Specification

/**
 * @ description: SortListTest
 * @ author: Liu Ran
 * @ data: 5/9/23 13:34
 */
class SortListTest extends Specification {
  var solution = new SortList()

  def "SortList"() {
    expect:
    solution.sortList(ListNodes.from(head)) == ListNodes.from(result)
    where:
    head         || result
    [4, 2, 1, 3] || [1, 2, 3, 4]
  }

  def "SortListV2"() {
    expect:
    solution.sortListV2(ListNodes.from(head)) == ListNodes.from(result)
    where:
    head         || result
    [4, 2, 1, 3] || [1, 2, 3, 4]
  }
}
