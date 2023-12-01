package com.lura.leetcode.top100

import spock.lang.Specification

/**
 * GenerateParenthesesTest
 * @author Liu Ran
 */
class GenerateParenthesesTest extends Specification {
  var solution = new GenerateParentheses()

  def "GenerateParenthesis"() {
    expect:
    solution.generateParenthesis(n) == res
    where:
    n || res
    3 || ["((()))", "(()())", "(())()", "()(())", "()()()"]
    1 || ["()"]
  }
}
