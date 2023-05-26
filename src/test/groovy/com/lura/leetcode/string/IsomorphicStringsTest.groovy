package com.lura.leetcode.string

import spock.lang.Specification

/**
 * @ description: IsomorphicStringsTest
 * @ author: Liu Ran
 * @ data: 5/26/23 09:13
 */
class IsomorphicStringsTest extends Specification {
  var solution = new IsomorphicStrings()

  def "IsIsomorphic"() {
    expect:
    solution.isIsomorphic(s, t) == res
    where:
    s       | t       || res
    "egg"   | "add"   || true
    "foo"   | "bar"   || false
    "paper" | "title" || true
    "badc"  | "baba"  || false
  }

  def "IsIsomorphicV2"() {
    expect:
    solution.isIsomorphicV2(s, t) == res
    where:
    s       | t       || res
    "egg"   | "add"   || true
    "foo"   | "bar"   || false
    "paper" | "title" || true
    "badc"  | "baba"  || false
  }
}
