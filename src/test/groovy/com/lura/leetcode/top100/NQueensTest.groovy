package com.lura.leetcode.top100

import spock.lang.Specification

class NQueensTest extends Specification {
    var solution = new NQueens()

    def "SolveNQueens"() {
        expect:
        solution.solveNQueens(n) == res
        where:
        n || res
        4 || [[".Q..", "...Q", "Q...", "..Q."], ["..Q.", "Q...", "...Q", ".Q.."]]
    }
}
