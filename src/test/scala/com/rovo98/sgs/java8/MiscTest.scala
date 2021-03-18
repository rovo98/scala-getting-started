package com.rovo98.sgs.java8

object MiscTest {
  def main(args: Array[String]): Unit = {
    // float point representation does not support associative
    println((3.14 + 1e20) - 1e20) // 0.00
    println(3.14 + (1e20 - 1e20)) // 3.14
  }
}
