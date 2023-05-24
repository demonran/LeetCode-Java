package com.lura.leetcode.string

import spock.lang.Specification

/**
 * @ description: AddBinaryTest
 * @ author: Liu Ran
 * @ data: 5/24/23 13:28
 */
class AddBinaryTest extends Specification {
  var solution = new AddBinary()

  def "AddBinary"() {
    expect:
    solution.addBinary(a, b) == res
    where:
    a      | b      || res
    "11"   | "1"    || "100"
    "1010" | "1011" || "10101"
  }
}
