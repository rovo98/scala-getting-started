package com.rovo98.inaction.scalaindepth

// Combining predicate function (T => Boolean) and return (T => Boolean)
object Predicates {
  // Explicit anonymous function
  def or[T](f1: T => Boolean, f2: T => Boolean) = (t: T) => f1(t) || f2(t)
  def and[T](f1: T => Boolean, f2: T => Boolean) = (t: T) => f1(t) && f2(t)
  def notNull[T]: T => Boolean = _ != null // Placeholder function syntax
}

object DropVerboseSyntax {




  def qSort[T](list: List[T])(implicit ot: T => Ordered[T]): List[T] =
    list match {
      case Nil => Nil
      case x::xs =>
        val (before, after) = xs.partition( _ < x);
        qSort(before) ++ (x :: qSort(after))
    }

  def main(args: Array[String]): Unit = {
    val l = List(1, 4, 5, 2, 8, 22, 9)
    println(qSort(l))
  }
}