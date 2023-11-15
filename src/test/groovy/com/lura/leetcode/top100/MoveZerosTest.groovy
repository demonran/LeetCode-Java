package com.lura.leetcode.top100

import spock.lang.Specification

/**
 * MoveZerosTest
 * @author Liu Ran
 */
class MoveZerosTest extends Specification {
  var solution = new MoveZeros();

  def "MoveZeroes"() {
    expect:
    solution.moveZeroes(nums)
    nums == res
    where:
    nums                      || res
    [0, 1, 0, 3, 12] as int[] || [1, 3, 12, 0, 0] as int[]
    [0, 0, 1] as int[]        || [1, 0, 0] as int[]

  }
}
