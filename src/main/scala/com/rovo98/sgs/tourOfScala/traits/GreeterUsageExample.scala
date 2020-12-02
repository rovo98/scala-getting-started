package com.rovo98.sgs.tourOfScala.traits

object GreeterUsageExample {
  def main(args: Array[String]): Unit = {
    val greeter = new DefaultGreeter()
    greeter.greet("Scala developer")

    val customGreeter = new CustomizableGreeter("How are you, ", "?")
    customGreeter.greet("Scala developer")
  }
}

class DefaultGreeter extends Greeter

class CustomizableGreeter(prefix: String, postfix: String) extends Greeter {
  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}
