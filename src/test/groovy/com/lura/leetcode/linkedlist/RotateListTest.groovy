package com.lura.leetcode.linkedlist

import com.lura.leetcode.problemset.linkedlist.RotateList
import com.lura.leetcode.problemset.struct.ListNodes
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
    solution.rotateRight(ListNodes.from(head), k) == ListNodes.from(result)
    where:
    head            | k || result
    [1, 2, 3, 4, 5] | 2 || [4, 5, 1, 2, 3]
    [0, 1, 2]       | 4 || [2, 0, 1]
  }

  def "rotateRightV2"() {
    expect:
    solution.rotateRightV2(ListNodes.from(head), k) == ListNodes.from(result)
    where:
    head            | k || result
    [1, 2, 3, 4, 5] | 2 || [4, 5, 1, 2, 3]
    [0, 1, 2]       | 4 || [2, 0, 1]
  }
}
