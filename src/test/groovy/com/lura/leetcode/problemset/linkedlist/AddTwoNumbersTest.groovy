package com.lura.leetcode.problemset.linkedlist

import com.lura.leetcode.problemset.linkedlist.AddTwoNumbers
import com.lura.leetcode.problemset.struct.ListNode
import spock.lang.Specification

class AddTwoNumbersTest extends Specification {

    var solution = new AddTwoNumbers()

    def "AddTwoNumbers"() {
        expect:
        ListNode.toList(solution.addTwoNumbers(ListNode.from(l1), ListNode.from(l2))) == result;
        where:
        l1                                                                                                     | l2                                      || result
        [2, 4, 3] as int[]                                                                                     | [5, 6, 4] as int[]                      || [7, 0, 8]
        [0] as int[]                                                                                           | [0] as int[]                            || [0]
        [9, 9, 9, 9, 9, 9, 9] as int[]                                                                         | [9, 9, 9, 9] as int[]                   || [8, 9, 9, 9, 0, 0, 0, 1]
        [9] as int[]                                                                                           | [1, 9, 9, 9, 9, 9, 9, 9, 9, 9] as int[] || [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]
        [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1] as int[] | [5, 6, 4] as int[]                      || [6, 6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]
        [5] as int[]                                                                                           | [5] as int[]                            || [0, 1]
    }

    def "AddTwoNumbersV2"() {
        expect:
        ListNode.toList(solution.addTwoNumbersV2(ListNode.from(l1), ListNode.from(l2))) == result;
        where:
        l1                                                                                                     | l2                                      || result
        [2, 4, 3] as int[]                                                                                     | [5, 6, 4] as int[]                      || [7, 0, 8]
        [0] as int[]                                                                                           | [0] as int[]                            || [0]
        [9, 9, 9, 9, 9, 9, 9] as int[]                                                                         | [9, 9, 9, 9] as int[]                   || [8, 9, 9, 9, 0, 0, 0, 1]
        [9] as int[]                                                                                           | [1, 9, 9, 9, 9, 9, 9, 9, 9, 9] as int[] || [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]
        [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1] as int[] | [5, 6, 4] as int[]                      || [6, 6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]
        [5] as int[]                                                                                           | [5] as int[]                            || [0, 1]
    }

}
