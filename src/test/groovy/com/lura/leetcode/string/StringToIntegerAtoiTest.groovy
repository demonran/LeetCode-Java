package com.lura.leetcode.string

import com.lura.leetcode.problemset.string.StringToIntegerAtoi
import spock.lang.Specification

/**
 * @ description: StringToIntegerAtoiTest
 * @ author: Liu Ran
 * @ data: 6/19/23 17:06
 */
class StringToIntegerAtoiTest extends Specification {
  def solution = new StringToIntegerAtoi()

  def "MyAtoi"() {
    expect:
    solution.myAtoi(s) == res
    where:
    s                 || res
    "42"              || 42
    "   -42"          || -42
    "4193 with words" || 4193
    "00000-42a1234"   || 0
  }

  def "MyAtoiV2"() {
    expect:
    solution.myAtoiV2(s) == res
    where:
    s                 || res
    "42"              || 42
    "   -42"          || -42
    "4193 with words" || 4193
    "00000-42a1234"   || 0
  }
}
