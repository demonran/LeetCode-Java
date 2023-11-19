package com.lura.leetcode.top100

import spock.lang.Specification

/**
 * RotateArrayTest
 * @author Liu Ran
 */
class RotateArrayTest extends Specification {
  var solution = new RotateArray()

  def "Rotate"() {
    expect:
    solution.rotate(nums, k)
    nums == res
    where:
    nums                  | k || res
    [1, 2, 3, 4] as int[] | 1 || [4, 1, 2, 3] as int[]
  }
}
