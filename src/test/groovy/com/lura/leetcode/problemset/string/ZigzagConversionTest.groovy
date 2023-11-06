package com.lura.leetcode.problemset.string

import com.lura.leetcode.problemset.string.ZigzagConversion
import spock.lang.Specification

/**
 * @ description: ZigzagConversionTest
 * @ author: Liu Ran
 * @ data: 6/17/23 17:25
 */
class ZigzagConversionTest extends Specification {
  def solution = new ZigzagConversion()

  def "Convert"() {
    expect:
    solution.convert(s, numRows) == res
    where:
    s                | numRows || res
    "PAYPALISHIRING" | 3       || "PAHNAPLSIIGYIR"
    "PAYPALISHIRING" | 4       || "PINALSIGYAHRPI"

  }

  def "ConvertV2"() {
    expect:
    solution.convertV2(s, numRows) == res
    where:
    s                | numRows || res
    "PAYPALISHIRING" | 3       || "PAHNAPLSIIGYIR"
    "PAYPALISHIRING" | 4       || "PINALSIGYAHRPI"
    "ABCDE"          | 4       || "ABCED"
  }

  def "ConvertV3"() {
    expect:
    solution.convertV3(s, numRows) == res
    where:
    s                | numRows || res
    "PAYPALISHIRING" | 3       || "PAHNAPLSIIGYIR"
    "PAYPALISHIRING" | 4       || "PINALSIGYAHRPI"
    "ABCDE"          | 4       || "ABCED"
  }
}
