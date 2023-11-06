package com.lura.leetcode.string

import com.lura.leetcode.problemset.string.IntegerToRoman
import spock.lang.Specification

/**
 * @ description: IntegerToRomanTest
 * @ author: Liu Ran
 * @ data: 6/20/23 16:16
 */
class IntegerToRomanTest extends Specification {
  def solution = new IntegerToRoman()

  def "IntToRoman"() {
    expect:
    solution.intToRoman(num) == res
    where:
    num  || res
    3    || "III"
    4    || "IV"
    9    || "IX"
    58   || "LVIII"
    1994 || "MCMXCIV"
  }

  def "IntToRomanV2"() {
    expect:
    solution.intToRomanV2(num) == res
    where:
    num  || res
    3    || "III"
    4    || "IV"
    9    || "IX"
    58   || "LVIII"
    1994 || "MCMXCIV"
  }

  def "IntToRomanV3"() {
    expect:
    solution.intToRomanV3(num) == res
    where:
    num  || res
    3    || "III"
    4    || "IV"
    9    || "IX"
    58   || "LVIII"
    80   || "LXXX"
    1994 || "MCMXCIV"
  }
}
