package com.rovo98.scalatest.example

import org.scalatest.flatspec.AnyFlatSpec

import scala.collection.mutable

class StackSpec extends AnyFlatSpec {
  "A stack" should "pop values in last-in-first-out(fifo) order" in {
    val stack = new mutable.Stack[Int]
    stack.push(1)
    stack.push(2)
    assert(stack.pop() === 2)
    assert(stack.pop() === 1)
  }
  it should "throw NoSuchElementException if a empty stack is popped" in {
    val emptyStack = new mutable.Stack[String]
    assertThrows[NoSuchElementException] {
      emptyStack.pop()
    }
  }
  "Put one value into the stack then it" should "pop back the same value" in {
    val stack = new mutable.Stack[Int]
    stack.push(100)
    assertResult(100) {
      stack.pop()
    }
  }
}