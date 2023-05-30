package com.lura.leetcode.string

import spock.lang.Specification

/**
 * @ description: ReverseStringTest
 * @ author: Liu Ran
 * @ data: 5/30/23 12:51
 */
class ReverseStringTest extends Specification {
  def solution = new ReverseString()

  def "ReverseString"() {
    when:
    def s = str.toCharArray()
    solution.reverseString(s)
    then:
    s == t.toCharArray()
    where:
    str     || t
    "hello" || "olleh"
    "123"   || "321"
    "1234"  || "4321"
  }
}
