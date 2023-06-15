package com.lura.leetcode.string

import spock.lang.Specification

/**
 * @ description: LongestSubstringWithoutRepeatingCharactersTest
 * @ author: Liu Ran
 * @ data: 6/15/23 12:44
 */
class LongestSubstringWithoutRepeatingCharactersTest extends Specification {
  def solution = new LongestSubstringWithoutRepeatingCharacters()

  def "LengthOfLongestSubstring"() {
    expect:
    solution.lengthOfLongestSubstring(s) == res
    where:
    s          || res
    "abcabcbb" || 3
    "bbbbb"    || 1
    "pwwkew"   || 3
  }
}
