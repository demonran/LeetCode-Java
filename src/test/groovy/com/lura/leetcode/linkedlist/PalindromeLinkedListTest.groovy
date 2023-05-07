package com.lura.leetcode.linkedlist

import com.lura.leetcode.struct.ListNodes
import spock.lang.Specification

/**
 * @ description: PalindromeLinkedListTest
 * @ author: Liu Ran
 * @ data: 5/7/23 11:22
 */
class PalindromeLinkedListTest extends Specification {
  var solution = new PalindromeLinkedList()

  def "IsPalindrome"() {
    expect:
    solution.isPalindrome(ListNodes.from(head)) == result
    where:
    head         || result
    [1, 2, 2, 1] || true
    [1, 2]       || false
  }

  def "IsPalindromeV2"() {
    expect:
    solution.isPalindromeV2(ListNodes.from(head)) == result
    where:
    head         || result
    [1, 2, 2, 1] || true
    [1, 2]       || false
  }

  def "IsPalindromeV3"() {
    expect:
    solution.isPalindromeV3(ListNodes.from(head)) == result
    where:
    head         || result
    [1, 2, 2, 1] || true
    [1, 2]       || false
  }
}
