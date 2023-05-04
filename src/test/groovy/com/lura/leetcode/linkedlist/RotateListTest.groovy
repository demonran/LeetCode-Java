package com.lura.leetcode.linkedlist

import com.lura.leetcode.struct.ListNode
import com.lura.leetcode.struct.ListNodeFactory
import com.lura.leetcode.struct.ListNodes
import spock.lang.Specification

/**
 * @ description: RotateListTest
 * @ author: Liu Ran
 * @ data: 5/4/23 20:07
 */
class RotateListTest extends Specification {
  var solution = new RotateList()


  def "RotateRight"() {
    expect:
    solution.rotateRight(ListNodeFactory.from(head), k) == ListNodeFactory.from(result)
    where:
    head            | k || result
    [1, 2, 3, 4, 5] | 2 || [4, 5, 1, 2, 3]
    [0, 1, 2]       | 4 || [2, 0, 1]
  }

  def "rotateRightV2"() {
    expect:
    solution.rotateRightV2(ListNodeFactory.from(head), k) == ListNodeFactory.from(result)
    where:
    head            | k || result
    [1, 2, 3, 4, 5] | 2 || [4, 5, 1, 2, 3]
    [0, 1, 2]       | 4 || [2, 0, 1]
  }
}
