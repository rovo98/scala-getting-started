package com.rovo98.sgs.java8

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DupTests extends AnyFlatSpec with Matchers {
  "duplicateCount(\"abcde\")" should "return 0" in {
    DuplicatesCount.duplicatedCount("abcde") should be (0)
  }
  "duplicateCount(\"aabbcde\")" should "return 2" in {
    DuplicatesCount.duplicateCount("aabbcde") should be (2)
  }
  "duplicateCount(\"aabBcde\")" should "return 2" in {
    DuplicatesCount.duplicatedCount("aabBcde") should be (2)
  }
  "duplicateCount(\"indivisibility\")" should "return 1" in {
    DuplicatesCount.duplicatedCount("indivisibility") should be (1)
  }
  "duplicateCount(\"aA11\")" should "return 2" in {
    DuplicatesCount.duplicatedCount("aA11") should be (2)
  }
  "duplicateCount(\"ABBA\")" should "return 2" in {
    DuplicatesCount.duplicatedCount("ABBA") should be (2)
  }
}
