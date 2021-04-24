package com.rovo98.scalatest.example

import java.io.File

import org.scalatest.Inspectors.forAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.MatcherProducers.convertToComposifier
import org.scalatest.matchers.{LazyArg, MatchResult, Matcher}
import org.scalatest.matchers.should.Matchers

class MatcherUsingExample extends AnyFlatSpec with Matchers {

  "Equality testing" should "be easy" in {
    val result = 3
    result shouldBe 3
    result shouldEqual 3

    val arr = Array(1, 2)
    arr shouldEqual Array(1, 2)
    arr should have length 2
    arr should have size 2

    val string = "Hello, seven yuan today, world"
    string should startWith("Hello")
    string should endWith("world")
    string should include("seven")

    string should fullyMatch regex """.*?"""

    "abbccxxx" should startWith regex ("a(b*)(c*)" withGroups("bb", "cc"))
    "xxxabbcc" should endWith regex ("a(b*)(c*)" withGroups("bb", "cc"))
    "xxxabbccxxx" should include regex ("a(b*)(c*)" withGroups("bb", "cc"))
    "abbcc" should fullyMatch regex ("a(b*)(c*)" withGroups("bb", "cc"))
  }

  "Contains checking" should "be easy" in {
    List(1, 2, 3) should contain(2)
    Map('a' -> 1, 'b' -> 2, 'c' -> 3) should contain ('b' -> 2)
    Set(1, 2, 3) should contain (2)
    Array(1, 2, 3) should contain (2)
    "123" should contain ('2')
    Some(2) should contain (2)

    List(1, 2, 3, 4, 5) should contain oneOf (5, 7, 9)
    Some(7) should contain oneOf (5, 7, 9)
    "howdy" should contain oneOf ('a', 'b', 'c', 'd')

    List(1, 2, 3) should contain atLeastOneOf (2, 3, 4)
    Array(1, 2, 3) should contain atLeastOneOf (3, 4, 5)
    "abc" should contain atLeastOneOf ('c', 'a', 't')

    List(1, 2, 3, 4, 5) should contain atMostOneOf (5, 6, 7)
    List(1, 2, 3, 4, 5) should contain allOf (2, 3, 5)
    List(1, 2, 3, 2, 1) should contain only (1, 2, 3)
    List(1, 2, 2, 3, 3, 3) should contain theSameElementsAs Vector(3, 2, 3, 1, 2, 3)

    List(1, 2, 2, 3, 3, 3) should contain inOrderOnly (1, 2, 3)
    List(0, 1, 2, 2, 99, 3, 3, 3, 5) should contain inOrder (1, 2, 3)
    List(1, 2, 3) should contain theSameElementsInOrderAs collection.mutable.TreeSet(3, 2, 1)
  }

  "Working with sortables" should "be easy" in {
    List(1, 2, 3) shouldBe sorted
  }

  "Working with iterators" should "be easy" in {
    val it = List(1, 2, 3).iterator
    it.toStream should contain (2)
  }

  "Inspector shorthands" should "be fun" in {
    // multi-dimensional collection
    val yss = List(
      List(1, 2, 3),
      List(1, 2, 3),
      List(1, 2, 3)
    )

    forAll (yss) { ys =>
      forAll (ys) { y => y should be > 0}
    }

    // one-dimensional collection
    val xs = List(1, 2, 3)
    forAll (xs) { x => x should be < 10}
    // or
    all (xs) should be < 10
    // all inspectors shorthands
    /*
    all - succeeds if the assertion holds true for every element
    atLeast - succeeds if the assertion holds true for at least the specified number of elements
    atMost - succeeds if the assertion holds true for at most the specified number of elements.
    between - succeeds if the assertion holds true for between the specified minimum and maximum number of elements, inclusive
    every - same as all, but lists all failing elements if it fails (whereas all just reports the first failing element)
    exactly - succeeds if the assertion holds true for exactly the specified number of elements
     */

    val xss = List(1, 2, 3, 4, 5)
    all (xss) should be >0
    atMost(2, xss) should be >= 4
    atLeast(3, xss) should be < 5
    between(2, 3, xss) should (be > 1 and be < 5)
    exactly(2, xss) should be <=2
    every (xss) should be < 10
  }

  "Custom matcher" should "be interesting" in {
    val hidden = 'hidden

    new File("secret.txt") shouldBe hidden

    val beWithinTolerance = be >= 0 and be <= 10
    val num = 10
    num should beWithinTolerance

    val beOdd = Matcher { (left: Int) =>
      MatchResult(
        left % 2 == 1,
        left + " was not odd",
        left + " was odd"
      )
    }

    3 should beOdd
    4 should not (beOdd)
  }

  "Composing matchers" should "be used" in {
    def endWithExtension(ext: String) = endWith(ext) compose { (f: File) => f.getPath}

    new File("output.txt") should endWithExtension("txt")

    // composing twice
    val f = be > (_: Int)
    val g = (_: String).toInt
    val beAsIntsGreaterThan = (f compose g) andThen (_ compose g)
    "8" should beAsIntsGreaterThan ("7")

    val beAsIntGreaterThan = f composeTwice g mapResult { mr =>
      mr.copy(
        failureMessageArgs = mr.failureMessageArgs.map(LazyArg(_) { "\"" + _.toString + "\".toInt"}),
        negatedFailureMessageArgs = mr.negatedFailureMessageArgs.map(LazyArg(_) { "\"" + _.toString + "\".toInt"}),
        midSentenceFailureMessageArgs =
          mr.midSentenceFailureMessageArgs.map(LazyArg(_) { "\"" + _.toString + "\".toInt"}),
        midSentenceNegatedFailureMessageArgs =
          mr.midSentenceNegatedFailureMessageArgs.map(LazyArg(_) { "\"" + _.toString + "\".toInt"})
      )
    }
    "7" should beAsIntGreaterThan ("8")
  }

  "Checking for expected exceptions" should "be easy" in {
    val s = "hello, world"
    an [IndexOutOfBoundsException] should be thrownBy s.charAt(-1)

    // capture the exception for further processing
    val thrown  = the [IndexOutOfBoundsException] thrownBy s.charAt(-1)
    thrown.getMessage should equal ("String index out of range: -1")

    // inspect an expected exception in one statement
    the [ArithmeticException] thrownBy 1 / 0 should have message "/ by zero"
    the [IndexOutOfBoundsException] thrownBy {
      s.charAt(-1)
    } should have message "String index out of range: -1"
  }
}

trait CustomMatchers {
  class FileEndsWithExtensionMatcher(expectedExtension: String) extends Matcher[File] {
    def apply(left: File) = {
      val name = left.getName
      MatchResult(
        name.endsWith(expectedExtension),
        s"""File $name did not end with extension "$expectedExtension"""",
        s"""File $name ended with extension "$expectedExtension""""
      )
    }
    def endWithExtension(expectedExtension: String) = new FileEndsWithExtensionMatcher(expectedExtension)
  }
}

// make them easy to import with:
// import CustomMatchers._
object CustomMatchers extends CustomMatchers

