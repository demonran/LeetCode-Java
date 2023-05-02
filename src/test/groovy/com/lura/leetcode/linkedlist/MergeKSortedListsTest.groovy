package com.lura.leetcode.linkedlist

import com.lura.leetcode.struct.ListNode
import com.lura.leetcode.struct.ListNodeFactory
import spock.lang.Specification

class MergeKSortedListsTest extends Specification {
    var solution = new MergeKSortedLists()

    def "MergeKLists"() {
        expect:
        ListNodeFactory.toList(solution.mergeKLists(ListNodeFactory.from(nodes))) == result

        where:
        nodes                                     || result
        [[1, 4, 5], [1, 3, 4], [2, 6]] as int[][] || [1, 1, 2, 3, 4, 4, 5, 6]
    }
}
