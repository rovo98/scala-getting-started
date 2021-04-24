package com.rovo98.scalatest.example

import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.concurrent.Future

class AddAsyncSpec extends AsyncFlatSpec with Matchers {

  def addSoon(addends: Int*): Future[Int] = Future {
    addends.sum
  }
  behavior of "addSoon"
  it should "eventually compute a sum of passed Ints" in {
    val futureSum: Future[Int] = addSoon(1, 2)
    // you can map assertions onto a future, then return the resulting Future[Assertion] to ScalaTest
    futureSum map { sum => sum should equal (3)}
  }

  def addNow(addends: Int*): Int = addends.sum

  "addNow" should "immediately compute a sum of passed Ints" in {
    val sum: Int = addNow(1, 2)
    // You can also write synchronous tests. the body must have result type Assertion.
    sum should equal (3)
  }
}
