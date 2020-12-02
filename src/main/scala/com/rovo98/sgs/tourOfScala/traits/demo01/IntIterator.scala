package com.rovo98.sgs.tourOfScala.traits.demo01

class IntIterator(to: Int) extends Iterator[Int] {
  private var current = 0
  override def hasNext: Boolean = current < to

  override def next(): Int = {
    if (hasNext) {
      val t = current
      current += 1
      t
    } else 0
  }
}

object IntIteratorExample {
  def main(args: Array[String]): Unit = {
    val iterator = new IntIterator(10)

    while (iterator.hasNext)
      print(iterator.next() + " ")
  }
}
