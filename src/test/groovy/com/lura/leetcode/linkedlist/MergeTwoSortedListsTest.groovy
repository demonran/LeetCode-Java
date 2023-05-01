package com.lura.leetcode.linkedlist

import com.lura.leetcode.struct.ListNode
import spock.lang.Specification

class MergeTwoSortedListsTest extends Specification {

    var solution = new MergeTwoSortedLists()


    def "MergeTwoLists"() {
        expect:
        ListNode.toList(solution.mergeTwoLists(ListNode.from(arr1), ListNode.from(arr2))) == result
        where:
        arr1               | arr2               || result
        [1, 2, 4] as int[] | [1, 3, 4] as int[] || [1, 1, 2, 3, 4, 4]
    }
}
