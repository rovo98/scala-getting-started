package com.rovo98.sgs.tourOfScala.mixin

class RichStringIter extends StringIterator("Scala") with RichIterator

object RichStringIter {
  def main(args: Array[String]): Unit = {
    val richStringIter = new RichStringIter
    richStringIter.foreach(println)
  }
}

