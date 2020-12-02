package com.rovo98.sgs.tourOfScala

class Greeter(prefix: String, suffix: String) {
  def pf: String = prefix
  def sf: String = suffix
  def greet(name: String): Unit = println(pf + name + sf)
}

object GreeterUsage {
  def main(args: Array[String]): Unit = {
    val greeter = new Greeter("Hello,", "!")
    greeter.greet("Scala developer")
  }
}
