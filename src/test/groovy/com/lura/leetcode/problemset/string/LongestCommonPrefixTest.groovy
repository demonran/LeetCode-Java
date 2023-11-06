package com.lura.leetcode.problemset.string

import com.lura.leetcode.problemset.string.LongestCommonPrefix
import spock.lang.Specification

/**
 * @ description: LongestCommonPrefixTest
 * @ author: Liu Ran
 * @ data: 5/21/23 20:12
 */
class LongestCommonPrefixTest extends Specification {
  var solution = new LongestCommonPrefix()

  def "LongestCommonPrefix"() {
    expect:
    solution.longestCommonPrefix(strs) == res
    where:
    strs                                     || res
    ["flower", "flow", "flight"] as String[] || "fl"
    ["dog", "racecar", "car"] as String[]    || ""
  }


  def "LongestCommonPrefixV2"() {
    expect:
    solution.longestCommonPrefixV2(strs) == res
    where:
    strs                                     || res
    ["flower", "flow", "flight"] as String[] || "fl"
    ["dog", "racecar", "car"] as String[]    || ""
  }
}
