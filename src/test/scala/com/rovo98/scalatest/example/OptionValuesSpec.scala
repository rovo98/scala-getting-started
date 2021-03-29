package com.rovo98.scalatest.example

import org.scalatest.OptionValues.convertOptionToValuable
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

/*
OptionValues trait 为 Option 类型对象增加一个 value 方法，当 Option 有定义时，返回其值，无定义时则返回 TestFailedException

而不是返回其他异常，如 NoSuchElementException
 */
class OptionValuesSpec extends AnyFlatSpec {
  "Option value check" should "be easy" in {
    val opt: Option[Int] = None

    //    opt.get should be > 9 // opt.get throws NoSuchElementException
    opt should be ('defined) // throws TestFailedException
  }

  "Option value check with OptionValues" should "be easy" in {
    val opt: Option[Int] = None
    opt.value should be > 9
  }
}
