package com.lura.leetcode.string

import spock.lang.Specification

/**
 * @ description: ReverseVowelsOfAStringTest
 * @ author: Liu Ran
 * @ data: 5/30/23 13:11
 */
class ReverseVowelsOfAStringTest extends Specification {
  def solution = new ReverseVowelsOfAString()

  def "ReverseVowels"() {
    expect:
    solution.reverseVowels(s) == res
    where:
    s          || res
    "hello"    || "holle"
    "leetcode" || "leotcede"
    "ai"       || "ia"
  }
}
