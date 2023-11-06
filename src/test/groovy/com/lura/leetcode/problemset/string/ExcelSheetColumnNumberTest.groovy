package com.lura.leetcode.problemset.string

import com.lura.leetcode.problemset.string.ExcelSheetColumnNumber
import spock.lang.Specification

/**
 * @ description: ExcelSheetColumnNumberTest
 * @ author: Liu Ran
 * @ data: 5/25/23 13:34
 */
class ExcelSheetColumnNumberTest extends Specification {
  var solution = new ExcelSheetColumnNumber()

  def "TitleToNumber"() {
    expect:
    solution.titleToNumber(title) == num
    where:
    title || num
    "A"   || 1
    "AB"  || 28
    "ZY"  || 701
  }
}
