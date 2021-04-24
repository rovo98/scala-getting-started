package com.rovo98.scalatest.example

import org.scalatest.Tag
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.tagobjects.Slow

object DbTest extends Tag("com.rovo98.scalatest.example.tag.DbTest")

class TagTest extends AnyFlatSpec {
  "The scala language" must "add correctly" taggedAs(Slow) in {
    val sum = 1 + 1
    assert(sum === 2)
  }
  it must "subtract correctly" taggedAs(Slow, DbTest) in {
    val diff = 4 - 1
    assert(diff === 3)
  }
}
