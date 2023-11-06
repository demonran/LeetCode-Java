package com.lura.leetcode.problemset.string

import com.lura.leetcode.problemset.string.FirstUniqueCharacterInAString
import spock.lang.Specification

/**
 * @ description: FirstUniqueCharacterInAStringTest
 * @ author: Liu Ran
 * @ data: 5/31/23 14:46
 */
class FirstUniqueCharacterInAStringTest extends Specification {
  def solution = new FirstUniqueCharacterInAString()

  def "FirstUniqChar"() {
    expect:
    solution.firstUniqChar(s) == res
    where:
    s              || res
    "leetcode"     || 0
    "loveleetcode" || 2
    "aabb"         || -1
  }
}
