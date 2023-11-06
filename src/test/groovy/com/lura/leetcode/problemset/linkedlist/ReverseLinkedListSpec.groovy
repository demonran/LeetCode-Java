package com.lura.leetcode.problemset.linkedlist


import com.lura.leetcode.struct.ListNodes
import spock.lang.Specification

class ReverseLinkedListSpec extends Specification {

  var solution = new ReverseLinkedList()

  def "ReverseList"() {
    def actual = solution.reverseList(ListNodes.from(head))
    expect:
    ListNodes.toList(actual) == result
    where:
    head            || result
    [1, 2, 3, 4, 5] || [5, 4, 3, 2, 1]
    [1, 2]          || [2, 1]
    []              || []
  }

  def "ReverseListV2"() {
    def actual = solution.reverseListV2(ListNodes.from(head))
    expect:
    ListNodes.toList(actual) == result
    where:
    head            || result
    [1, 2, 3, 4, 5] || [5, 4, 3, 2, 1]
    [1, 2]          || [2, 1]
    []              || []
  }
}
