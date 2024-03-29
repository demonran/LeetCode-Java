package com.lura.leetcode.problemset.backtracking

import com.lura.leetcode.problemset.backtracking.GenerateParentheses
import spock.lang.Specification

/**
 * @ description: GenerateParenthesesTest
 * @ author: Liu Ran
 * @ data: 6/25/23 16:40
 */
class GenerateParenthesesTest extends Specification {
  def solution = new GenerateParentheses()

  def "GenerateParenthesis"() {
    expect:
    solution.generateParenthesis(n) == res
    where:
    n || res
    3 || ["((()))", "(()())", "(())()", "()(())", "()()()"]
    1 || ["()"]
  }
}
