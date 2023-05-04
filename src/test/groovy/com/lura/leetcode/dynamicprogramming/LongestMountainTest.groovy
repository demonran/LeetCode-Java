package com.lura.leetcode.dynamicprogramming

import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.assertEquals

/**
 * @ description: LongestMountainTest
 * @ author: Liu Ran
 * @ data: 5/4/23 21:37
 */
class LongestMountainTest extends Specification {
  var solution = new LongestMountain();

  def "LongestMountain"() {
    expect:
    solution.longestMountain(arr) == result
    where:
    arr                            || result
    [2, 1, 4, 7, 3, 2, 5] as int[] || 5
  }

  def "LongestMountainV2"() {
    expect:
    solution.longestMountainV2(arr) == result
    where:
    arr                            || result
    [2, 1, 4, 7, 3, 2, 5] as int[] || 5
  }
}
