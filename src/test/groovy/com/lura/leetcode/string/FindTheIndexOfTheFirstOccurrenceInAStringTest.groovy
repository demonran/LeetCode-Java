package com.lura.leetcode.string

import spock.lang.Specification

/**
 * @ description: FindTheIndexOfTheFirstOccurrenceInAStringTest
 * @ author: Liu Ran
 * @ data: 6/26/23 17:01
 */
class FindTheIndexOfTheFirstOccurrenceInAStringTest extends Specification {
  def solution = new FindTheIndexOfTheFirstOccurrenceInAString()

  def "StrStr"() {
    expect:
    solution.strStr(haystack, needle) == res
    where:
    haystack    | needle  || res
    "sadbutsad" | "sad"   || 0
    "leetcode"  | "leeto" || -1
    "a"         | "a"     || 0
  }
}
