package com.lura.leetcode.string

import spock.lang.Specification
import sun.security.util.Length

/**
 * @ description: LengthOfLastWordTest
 * @ author: Liu Ran
 * @ data: 5/22/23 13:42
 */
class LengthOfLastWordTest extends Specification {
  var solution = new LengthOfLastWord()

  def "LengthOfLastWord"() {
    expect:
    solution.lengthOfLastWord(s) == res
    where:
    s                             || res
    "Hello World"                 || 5
    "   fly me   to   the moon  " || 4
    "luffy is still joyboy"       || 6
    ""                            || 0
    "a"                           || 1
    " "                           || 0
  }

  def "LengthOfLastWordV2"() {
    expect:
    solution.lengthOfLastWordV2(s) == res
    where:
    s                             || res
    "Hello World"                 || 5
    "   fly me   to   the moon  " || 4
    "luffy is still joyboy"       || 6
    ""                            || 0
    "a"                           || 1
    " "                           || 0
  }

  def "LengthOfLastWordV3"() {
    expect:
    solution.lengthOfLastWordV3(s) == res
    where:
    s                             || res
    "Hello World"                 || 5
    "   fly me   to   the moon  " || 4
    "luffy is still joyboy"       || 6
    ""                            || 0
    "a"                           || 1
    " "                           || 0
  }
}
