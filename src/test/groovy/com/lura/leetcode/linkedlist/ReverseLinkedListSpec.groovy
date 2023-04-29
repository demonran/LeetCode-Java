package com.lura.leetcode.linkedlist

import com.lura.leetcode.struct.ListNode
import spock.lang.Specification

class ReverseLinkedListSpec extends Specification {

    var solution = new ReverseLinkedList()

    def "ReverseList"() {
        expect:
        ListNode.toList(solution.reverseList(ListNode.from(head))) == result
        where:
        head                     || result
        [1, 2, 3, 4, 5] as int[] || [5, 4, 3, 2, 1]
        [1, 2] as int[]          || [2, 1]
        [] as int[]              || []
    }
}
