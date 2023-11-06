package com.lura.leetcode.problemset.linkedlist

import com.lura.leetcode.problemset.linkedlist.MergeTwoSortedLists
import com.lura.leetcode.problemset.struct.ListNodes
import spock.lang.Specification

class MergeTwoSortedListsTest extends Specification {

  var solution = new MergeTwoSortedLists()


  def "MergeTwoLists"() {
    expect:
    solution.mergeTwoLists(ListNodes.from(arr1), ListNodes.from(arr2)) == ListNodes.from(result)
    where:
    arr1      | arr2      || result
    [1, 2, 4] | [1, 3, 4] || [1, 1, 2, 3, 4, 4]
  }

  def "MergeTwoListsV2"() {
    expect:
    solution.mergeTwoListsV2(ListNodes.from(arr1), ListNodes.from(arr2)) == ListNodes.from(result)
    where:
    arr1      | arr2      || result
    [1, 2, 4] | [1, 3, 4] || [1, 1, 2, 3, 4, 4]
  }
}
