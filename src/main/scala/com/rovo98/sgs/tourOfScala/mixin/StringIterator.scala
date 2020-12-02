package com.rovo98.sgs.tourOfScala.mixin

class StringIterator(s: String) extends AbsIterator {
  override type T = Char
  private var i = 0

  override def hasNext: Boolean = i < s.length

  override def next(): Char = {
    val ch = s charAt i
    i += 1
    ch
  }
}
