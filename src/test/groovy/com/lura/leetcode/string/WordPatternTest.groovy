package com.lura.leetcode.string

import spock.lang.Specification

/**
 * @ description: WordPatternTest
 * @ author: Liu Ran
 * @ data: 5/29/23 16:03
 */
class WordPatternTest extends Specification {
  var solution = new WordPattern()

  def "WordPattern"() {
    expect:
    solution.wordPattern(pattern, s) == res
    where:
    pattern | s                  || res
    "abba"  | "dog cat cat dog"  || true
    "abba"  | "dog cat cat fish" || false
    "aaaa"  | "dog cat cat dog"  || false
  }
}
