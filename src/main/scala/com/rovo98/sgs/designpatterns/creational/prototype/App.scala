package com.rovo98.sgs.designpatterns.creational.prototype

object App {
  def main(args: Array[String]): Unit = {
    val original = new Sheep("Jolly")
    println("original: " + original)
    val cloned = original.deepClone
    println("cloned: " + cloned)
  }
}
/*
in plain words
> Create object based on an existing object through cloning.

When to use?
When an object is required that is similar to existing object or when
the creation would be expensive as compared to cloning.
 */
