package com.lura.leetcode.top100

import spock.lang.Specification

/**
 * FirstMissPositiveTest
 * @author Liu Ran
 */
class FirstMissPositiveTest extends Specification {
  var solution = new FirstMissPositive()

  def "FirstMissingPositiveV2"() {
    expect:
    solution.firstMissingPositiveV2(nums) == res
    where:
    nums                   || res
    [1, 2, 0] as int[]     || 3
    [3, 4, -1, 1] as int[] || 2
    [1] as int[]           || 2
    [1, 1] as int[]        || 2
  }
}
