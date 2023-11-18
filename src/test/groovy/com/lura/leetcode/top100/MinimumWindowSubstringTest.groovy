package com.lura.leetcode.top100

import spock.lang.Specification

/**
 * MinimumWindowSubstringTest
 * @author Liu Ran
 */
class MinimumWindowSubstringTest extends Specification {
  var solution = new MinimumWindowSubstring()

  def "MinWindow"() {
    expect:
    solution.minWindow(s, t) == res
    where:
    s               | t     || res
    "ADOBECODEBANC" | "ABC" || "BANC"
  }
}
