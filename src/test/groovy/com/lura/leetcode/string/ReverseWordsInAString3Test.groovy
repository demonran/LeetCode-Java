package com.lura.leetcode.string

import spock.lang.Specification

/**
 * @ description: ReverseWordsInAString3Test
 * @ author: Liu Ran
 * @ data: 6/9/23 13:27
 */
class ReverseWordsInAString3Test extends Specification {
  def solution = new ReverseWordsInAString3()

  def "ReverseWords"() {
    expect:
    solution.reverseWords(s) == res
    where:
    s                             || res
    "Let's take LeetCode contest" || "s'teL ekat edoCteeL tsetnoc"
    "God Ding"                    || "doG gniD"
  }

  def "ReverseWordsV2"() {
    expect:
    solution.reverseWordsV2(s) == res
    where:
    s                             || res
    "Let's take LeetCode contest" || "s'teL ekat edoCteeL tsetnoc"
    "God Ding"                    || "doG gniD"
  }
}
