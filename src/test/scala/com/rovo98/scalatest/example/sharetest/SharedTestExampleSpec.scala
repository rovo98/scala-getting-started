package com.rovo98.scalatest.example.sharetest

import org.scalatest.flatspec.AnyFlatSpec

class SharedTestExampleSpec extends AnyFlatSpec with StackBehaviors {
  // stack fixture creation methods
  def emptyStack = new Stack[Int]

  def fullStack = {
    val stack = new Stack[Int]
    for (i <- 0 until stack.MAX)
      stack.push(i)
    stack
  }

  def stackWithOneItem = {
    val stack = new Stack[Int]
    stack.push(9)
    stack
  }

  def stackWithOneItemLessThanCapacity = {
    val stack = new Stack[Int]
    for (i <- 1 to 9)
      stack.push(i)
    stack
  }

  val lastValueAdded = 9

  "A Stack (when empty)" should "be empty" in {
    assert(emptyStack.empty)
  }

  it should "complain on peek" in {
    intercept[IllegalArgumentException] {
      emptyStack.peek
    }
  }

  it should "complain on pop" in {
    intercept[IllegalArgumentException] {
      emptyStack.pop()
    }
  }

  "A Stack (with one item)" should behave like nonEmptyStack(stackWithOneItem, lastValueAdded)
  it should behave like nonFullStack(stackWithOneItem)

  "A Stack (with one item less than capacity)" should behave like nonEmptyStack(stackWithOneItemLessThanCapacity, lastValueAdded)
  it should behave like nonFullStack(stackWithOneItemLessThanCapacity)

  "A Stack (full)" should "be full" in {
    assert(fullStack.full)
  }

  it should behave like nonEmptyStack(fullStack, lastValueAdded)

  it should "complain on a push" in {
    intercept[IllegalArgumentException] {
      fullStack.push(10)
    }
  }
}
