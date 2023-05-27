package com.lura.leetcode.string

import spock.lang.Specification

/**
 * @ description: ValidPalindromeTest
 * @ author: Liu Ran
 * @ data: 5/27/23 23:14
 */
class ValidPalindromeTest extends Specification {
  var solution = new ValidPalindrome()

  def "IsPalindrome"() {
    expect:
    solution.isPalindrome(s) == res
    where:
    s                                || res
    "A man, a plan, a canal: Panama" || true
    "race a car"                     || false
    " "                              || true
  }
}
