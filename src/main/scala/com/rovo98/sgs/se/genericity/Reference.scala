package com.rovo98.sgs.se.genericity

class Reference[T] {
  private var contents: T = _
  def set(value: T) { contents = value}
  def get(): T = contents
}
