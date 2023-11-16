package com.lura.leetcode.top100

import spock.lang.Specification

/**
 * TrappingRainWaterTest
 * @author Liu Ran
 */
class TrappingRainWaterTest extends Specification {
  var solution = new TrappingRainWater()

  def "Trap"() {
    expect:
    solution.trap(height) == res
    where:
    height                                        || res
    [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1] as int[] || 6
  }

  def "TrapV2"() {
    expect:
    solution.trapV2(height) == res
    where:
    height                                        || res
    [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1] as int[] || 6
  }

  def "TrapV3"() {
    expect:
    solution.trapV3(height) == res
    where:
    height                                        || res
    [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1] as int[] || 6
  }
}
