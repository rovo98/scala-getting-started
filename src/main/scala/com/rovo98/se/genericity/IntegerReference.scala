package com.rovo98.se.genericity

object IntegerReference {
  /**
   * Driver the program to test using genericity in scala.
   *
   * @param args command-line arguments.
   */
  def main(args: Array[String]): Unit = {
    val cell = new Reference[Int]
    cell.set(13)
    println("Reference contains the half of " + cell.get())
  }
}
