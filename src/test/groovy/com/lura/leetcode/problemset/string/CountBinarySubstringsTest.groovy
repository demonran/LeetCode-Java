package com.lura.leetcode.problemset.string

import com.lura.leetcode.problemset.string.CountBinarySubstrings
import spock.lang.Specification

/**
 * @ description: CountBinarySubstringsTest
 * @ author: Liu Ran
 * @ data: 6/12/23 17:12
 */
class CountBinarySubstringsTest extends Specification {
  def solution = new CountBinarySubstrings()

  def "CountBinarySubstrings"() {
    expect:
    solution.countBinarySubstrings(s) == res
    where:
    s          || res
    "00110011" || 6
    "10101"    || 4
  }

  def "CountBinarySubstringsV2"() {
    expect:
    solution.countBinarySubstringsV2(s) == res
    where:
    s          || res
    "00110011" || 6
    "10101"    || 4
  }
}
