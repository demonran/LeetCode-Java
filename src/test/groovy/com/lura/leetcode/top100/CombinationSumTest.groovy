package com.lura.leetcode.top100

import spock.lang.Specification

/**
 * CombinationSumTest
 * @author Liu Ran
 */
class CombinationSumTest extends Specification {
  var solution = new CombinationSum()

  def "CombinationSum"() {
    expect:
    solution.combinationSum(candidates, target) == res
    where:
    candidates            | target || res
    [2, 3, 6, 7] as int[] | 7      || [[2, 2, 3], [7]]
    [2, 3, 5] as int[]    | 8      || [[2,2,2,2],[2,3,3],[3,5]]
    [2] as int[]          | 1      || []
  }
}
