package com.lura.leetcode.linkedlist


import com.lura.leetcode.struct.ListNodes
import com.lura.leetcode.struct.TreeNodes
import spock.lang.Specification

/**
 * @ description: ConvertSortedListToBinarySearchTreeTest
 * @ author: Liu Ran
 * @ data: 5/6/23 18:52
 */
class ConvertSortedListToBinarySearchTreeTest extends Specification {
  var solution = new ConvertSortedListToBinarySearchTree()

  def "SortedListToBST"() {
    def actual = solution.sortedListToBST(ListNodes.from(head))
    expect:
    TreeNodes.toList(actual) == result
    where:
    head               || result
    [-10, -3, 0, 5, 9] || [0, -3, 9, -10, null, 5]
    []                 || []
  }

  def "SortedListToBSTV2"() {
    def actual = solution.sortedListToBSTV2(ListNodes.from(head))
    expect:
    TreeNodes.toList(actual) == result
    where:
    head               || result
    [-10, -3, 0, 5, 9] || [0, -3, 9, -10, null, 5]
    []                 || []
  }
}
