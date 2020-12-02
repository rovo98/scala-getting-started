package com.rovo98.sgs.tourOfScala.mixin

abstract class AbsIterator {
  type T
  def hasNext: Boolean
  def next(): T
}
