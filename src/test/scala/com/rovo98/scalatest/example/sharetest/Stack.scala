package com.rovo98.scalatest.example.sharetest

import scala.collection.mutable.ListBuffer

class Stack[T] {
  val MAX = 10
  private val buf = new ListBuffer[T]

  def push(o: T): Unit = {
    if (!full)
      buf.prepend(o)
    else throw new IllegalArgumentException("can't push onto a full stack")
  }
  def pop(): T = {
    if (!empty)
      buf.remove(0)
    else throw new IllegalArgumentException("can't pop an empty stack")
  }

  def peek: T = {
    if (!empty)
      buf(0)
    else
      throw new IllegalArgumentException("can't pop an empty stack")
  }

  def full: Boolean = buf.size == MAX
  def empty: Boolean = buf.isEmpty
  def size = buf.size

  override def toString: String = buf.mkString("Stack(", ", ", ")")
}
