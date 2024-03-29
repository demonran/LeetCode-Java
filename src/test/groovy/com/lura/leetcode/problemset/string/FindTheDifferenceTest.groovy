package com.lura.leetcode.problemset.string

import com.lura.leetcode.problemset.string.FindTheDifference
import spock.lang.Specification

class FindTheDifferenceTest extends Specification {
    def solution = new FindTheDifference()

    def "FindTheDifference"() {
        expect:
        solution.findTheDifference(s, t) == res as char
        where:
        s      | t       || res
        "abcd" | "abcde" || 'e'
        ""     | "y"     || 'y'
    }

    def "FindTheDifferenceV2"() {
        expect:
        solution.findTheDifferenceV2(s, t) == res as char
        where:
        s      | t       || res
        "abcd" | "abcde" || 'e'
        ""     | "y"     || 'y'
    }

    def "FindTheDifferenceV3"() {
        expect:
        solution.findTheDifferenceV3(s, t) == res as char
        where:
        s      | t       || res
        "abcd" | "abcde" || 'e'
        ""     | "y"     || 'y'
    }
}
