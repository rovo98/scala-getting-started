package com.rovo98.sgs.tourOfScala.genericClass

class Stack[A] {
  private var elements: List[A] = scala.Nil

  def push(x: A): Unit = elements = x :: elements
  def peek: A = elements.head
  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
}
