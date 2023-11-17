package com.lura.leetcode.top100

import spock.lang.Specification

/**
 * FindAllAnagramsInAStringTest
 * @author Liu Ran
 */
class FindAllAnagramsInAStringTest extends Specification {
  var solution = new FindAllAnagramsInAString()

  def "findAnagrams"() {
    expect:
    solution.findAnagrams(s, p) == res
    where:
    s            | p     || res
    "cbaebabacd" | "abc" || [0, 6]
  }

}
