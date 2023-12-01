package com.lura.leetcode.top100

import spock.lang.Specification

/**
 * WordSearchTest
 * @author Liu Ran
 */
class WordSearchTest extends Specification {
  var solution = new WordSearch()

  def "Exist"() {
    expect:
    solution.exist(board, word) == res
    where:
    board                                                                            | word         || res
    [["A", "B", "C", "E"], ["S", "F", "E", "S"], ["A", "D", "E", "E"]] as char[][] | "ABCESEEEFS" || true

  }
}
