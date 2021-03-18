package com.rovo98.scalatest.style

import org.scalatest.flatspec.AnyFlatSpec

// FlatSpec is recommended used for writing Unit-test and integration test.

class SetSpec extends AnyFlatSpec {
  "A empty Set" should "have size 0" in {
    assert(Set.empty.size == 0)
  }

  it should "produce NoSuchElementException when head is invoked" in {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }
}
