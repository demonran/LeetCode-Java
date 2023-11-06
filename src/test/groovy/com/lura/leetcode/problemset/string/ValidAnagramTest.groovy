package com.lura.leetcode.problemset.string

import com.lura.leetcode.problemset.string.ValidAnagram
import spock.lang.Specification

/**
 * @ description: ValidAnagramTest
 * @ author: Liu Ran
 * @ data: 5/28/23 23:08
 */
class ValidAnagramTest extends Specification {
  var solution = new ValidAnagram()

  def "IsAnagram"() {
    expect:
    solution.isAnagram(s, t) == res
    where:
    s         | t         || res
    "anagram" | "nagaram" || true
    "rat"     | "car"     || false
  }

  def "IsAnagramV2"() {
    expect:
    solution.isAnagramV2(s, t) == res
    where:
    s         | t         || res
    "anagram" | "nagaram" || true
    "rat"     | "car"     || false
  }
}
