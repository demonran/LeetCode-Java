package com.lura.leetcode.string

import spock.lang.Specification

/**
 * @ description: ValidParenthesesTest
 * @ author: Liu Ran
 * @ data: 5/23/23 13:56
 */
class ValidParenthesesTest extends Specification {
  var solution = new ValidParentheses()

  def "IsValid"() {
    expect:
    solution.isValid(s) == res
    where:
    s        || res
    "()"     || true
    "()[]{}" || true
    "(]"     || false
    "([)]"   || false
  }
}
