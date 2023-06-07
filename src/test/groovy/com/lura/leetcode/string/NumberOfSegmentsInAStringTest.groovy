package com.lura.leetcode.string

import spock.lang.Specification

/**
 * @ description: NumberOfSegmentsInAStringTest
 * @ author: Liu Ran
 * @ data: 6/6/23 17:17
 */
class NumberOfSegmentsInAStringTest extends Specification {
  def solution = new NumberOfSegmentsInAString()

  def "CountSegments"() {
    expect:
    solution.countSegments(s) == res
    where:
    s                        || res
    "Hello, my name is John" || 5
  }
}
