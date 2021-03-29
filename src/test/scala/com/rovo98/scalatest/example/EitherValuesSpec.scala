package com.rovo98.scalatest.example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.EitherValues._
import org.scalatest.matchers.should.Matchers._

/**
 * 和 OptionValues 的目的及作用类似
 */
class EitherValuesSpec extends AnyFlatSpec {
  "Check Either with EitherValues" should "be easy" in {
    val either: Either[String, Int] = Left("Muchas problems")

    either.left.value.length should be > 0
    either.right.value should be > 9
  }
}
