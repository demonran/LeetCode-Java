package com.lura.leetcode.problemset.sorting

import spock.lang.Specification

/**
 * SortAnArrayTest
 * @author Liu Ran
 */
class SortAnArrayTest extends Specification {
  var solution = new SortAnArray()

  def "QuickSort"() {
    expect:
    solution.quickSort(nums) == res
    where:
    nums         || res
    [5, 2, 3, 1] as int[]|| [1, 2, 3, 5] as int[]
  }

  def "bubbleSort"() {
    expect:
    solution.bubbleSort(nums) == res
    where:
    nums         || res
    [5, 2, 3, 1] as int[]|| [1, 2, 3, 5] as int[]
  }

  def "mergeSort"() {
    expect:
    solution.mergeSort(nums) == res
    where:
    nums         || res
    [5, 2, 3, 1] as int[]|| [1, 2, 3, 5] as int[]
  }

  def "selectSort"() {
    expect:
    solution.selectSort(nums) == res
    where:
    nums         || res
    [5, 2, 3, 1] as int[]|| [1, 2, 3, 5] as int[]
  }

  def "selectSortV2"() {
    expect:
    solution.selectSortV2(nums) == res
    where:
    nums         || res
    [5, 2, 3, 1] as int[]|| [1, 2, 3, 5] as int[]
  }
}
