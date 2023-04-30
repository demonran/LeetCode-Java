package com.lura.leetcode.linkedlist

import com.lura.leetcode.struct.ListNode
import spock.lang.Specification

class ReverseLinkedList2Test extends Specification {
    var solution = new ReverseLinkedList2()

    def "ReverseBetween"() {
        expect:
        ListNode.toList(solution.reverseBetween(ListNode.from(node), left, right)) == result
        where:
        node                     | left | right || result
        [1, 2, 3, 4, 5] as int[] | 2    | 4     || [1, 4, 3, 2, 5]
        [5] as int[]             | 1    | 1     || [5]
        [1, 2] as int[]          | 3    | 4     || [1, 2]

    }
}
