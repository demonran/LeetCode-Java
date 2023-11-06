package com.lura.leetcode.slidingwindow

import com.lura.leetcode.problemset.slidingwindow.MinimumWindowSubstring
import spock.lang.Specification

/**
 * @ description: MinimumWindowSubstringSpec
 * @ author: Liu Ran
 * @ data: 4/28/23 15:40
 */
class MinimumWindowSubstringSpec extends Specification {
  var solution = new MinimumWindowSubstring()

  def "MinWindow"() {
    expect:
    solution.minWindow(s, t) == r
    where:
    s               | t     || r
    "ADOBECODEBANC" | "ABC" || "BANC"
    "a"             | "a"   || "a"
    "a"             | "aa"  || ""
  }
}
