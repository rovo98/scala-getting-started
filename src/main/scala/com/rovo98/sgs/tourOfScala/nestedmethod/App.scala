package com.rovo98.sgs.tourOfScala.nestedmethod

import scala.annotation.tailrec

object App {
  def main(args: Array[String]): Unit = {
    def factorial(x: Int): Int = {
      @tailrec
      def fact(x: Int, accumulator: Int): Int = {
        if (x <= 1) accumulator
        else fact(x - 1, x * accumulator)
      }
      fact(x, 1)
    }

    println("Factorial of 2: " + factorial(2))
    println("Factorial of 3: " + factorial(3))
  }
}
