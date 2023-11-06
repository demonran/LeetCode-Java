package com.lura.leetcode.problemset.linkedlist


import com.lura.leetcode.struct.ListNodes
import spock.lang.Specification

/**
 * @ description: RemoveDuplicatesFromSortedList2Test
 * @ author: Liu Ran
 * @ data: 5/4/23 21:14
 */
class RemoveDuplicatesFromSortedList2Test extends Specification {
  var solution = new RemoveDuplicatesFromSortedList2()

  def "DeleteDuplicates"() {
    expect:
    solution.deleteDuplicates(ListNodes.from(head)) == ListNodes.from(result)
    where:
    head                  || result
    [1, 2, 3, 3, 4, 4, 5] || [1, 2, 5]
    [1, 1, 1, 2, 3]       || [2, 3]
    [1, 1]                || []
  }
}
