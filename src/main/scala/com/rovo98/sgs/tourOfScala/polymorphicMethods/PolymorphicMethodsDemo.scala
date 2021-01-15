package com.rovo98.sgs.tourOfScala.polymorphicMethods

object PolymorphicMethodsDemo {
  def main(args: Array[String]): Unit = {
    println(listOfDuplicates(1, 5))
    println(listOfDuplicates("La", 8).mkString(""))
  }
  def listOfDuplicates[A](x: A, length: Int): List[A] = {
    if (length < 1) Nil
    else x :: listOfDuplicates(x, length - 1)
  }
}
/*
Scala 中的方法可由类型（type）或值 (value) 进行参数化（parameterized)。语法与泛型类类似。
 */
