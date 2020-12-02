package com.rovo98.designpatterns.creational.singleton

import scala.util.control.Breaks.{break, breakable}

object App {
  def main(args: Array[String]): Unit = {
    President.instance.sayHello()

    breakable {
      for (i <- 0 to 10) {
        println("i = " + i)
        if (i == 8) break()
      }
    }
  }
}
/*
Ensures that only one object of a particular class is ever created
 */
