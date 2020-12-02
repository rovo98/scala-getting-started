package com.rovo98.sgs.tourOfScala.traits.demo01

trait Iterator[A] {
  def hasNext: Boolean
  def next(): A
}
