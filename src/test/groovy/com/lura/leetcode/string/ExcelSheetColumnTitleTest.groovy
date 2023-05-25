package com.lura.leetcode.string

import spock.lang.Specification

/**
 * @ description: ExcelSheetColumnTitleTest
 * @ author: Liu Ran
 * @ data: 5/25/23 13:09
 */
class ExcelSheetColumnTitleTest extends Specification {
  var solution = new ExcelSheetColumnTitle()

  def "ConvertToTitle"() {
    expect:
    solution.convertToTitle(num) == res
    where:
    num || res
    1   || "A"
    26  || "Z"
    27  || "AA"
    28  || "AB"
    701 || "ZY"
  }
}
