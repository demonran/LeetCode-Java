package com.lura.leetcode.string

import spock.lang.Specification

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 * @ description: AddStringsTest
 * @ author: Liu Ran
 * @ data: 6/5/23 18:51
 */
class AddStringsTest extends Specification {
  def solution = new AddStrings()

  def "AddStrings"() {
    expect:
    solution.addStrings(num1, num2) == res
    where:
    num1  | num2  || res
    "11"  | "123" || "134"
    "456" | "77"  || "533"
    "0"   | "0"   || "0"
    "456" | "77"  || "533"
  }

  def "AddStringsV2"() {
    expect:
    solution.addStringsV2(num1, num2) == res
    where:
    num1  | num2  || res
    "11"  | "123" || "134"
    "456" | "77"  || "533"
    "0"   | "0"   || "0"
    "456" | "77"  || "533"
  }
}
