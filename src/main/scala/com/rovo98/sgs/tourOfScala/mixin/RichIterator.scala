package com.rovo98.sgs.tourOfScala.mixin

trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit): Unit = while (hasNext) f(next())
}
