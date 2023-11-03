package com.lura.leetcode.binarysearch

import spock.lang.Specification

class BinarySearchTest extends Specification {
    var solution = new BinarySearch()

    def "BinarySearch"() {
        expect:
        solution.binarySearch(nums, target) == res
        where:
        nums               | target || res
        [1, 3, 4] as int[] | 3      || 1
        [1, 3, 4] as int[] | 2      || -1
        [1, 3, 4] as int[] | 5      || -1
    }
}
