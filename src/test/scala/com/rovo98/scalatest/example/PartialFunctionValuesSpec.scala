package com.rovo98.scalatest.example

import org.scalatest.PartialFunctionValues.convertPartialFunctionToValuable
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers._

class PartialFunctionValuesSpec extends AnyFlatSpec {
  "PartialFunction test" should "be easy" in {
    val pf: PartialFunction[String, Int] = Map("I" -> 1, "II" -> 2, "III" -> 3, "IV" -> 4)

    pf.valueAt("V") should be (5)
  }
  "Divide zero partial function" should "be checked" in {
    val divide: PartialFunction[Int, Int] = {
      case d: Int if d != 0 => 42 / d
    }
    an [ArithmeticException] should be thrownBy divide(0)
  }
}
