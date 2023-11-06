package com.lura.leetcode.problemset.string

import com.lura.leetcode.problemset.string.RansomNote
import spock.lang.Specification

/**
 * @ description: RansomNoteTest
 * @ author: Liu Ran
 * @ data: 5/30/23 15:51
 */
class RansomNoteTest extends Specification {
  def solution = new RansomNote()

  def "CanConstruct"() {
    expect:
    solution.canConstruct(r, m) == res
    where:
    r    | m     || res
    "a"  | "b"   || false
    "aa" | "ab"  || false
    "aa" | "aab" || true
  }

  def "CanConstructV2"() {
    expect:
    solution.canConstructV2(r, m) == res
    where:
    r    | m     || res
    "a"  | "b"   || false
    "aa" | "ab"  || false
    "aa" | "aab" || true
  }
}
