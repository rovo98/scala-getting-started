package com.rovo98.sgs.tourOfScala

trait GreeterTrait {
  def greet(name: String): Unit = println("Hello, " + name + "!")
  def hello(): Unit
}

class DefaultGreeter extends GreeterTrait {
  override def hello(): Unit = println("Hello world!")
}

class CustomizableGreeter(prefix: String, postfix: String) extends GreeterTrait {
  override def hello(): Unit = println("Hello world!")

  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}

object TraitsSimpleUsage {
  def main(args: Array[String]): Unit = {
    val greeter = new DefaultGreeter()
    greeter.greet("Scala developer")
    val customGreeter = new CustomizableGreeter("How are you, ", "?")
    customGreeter.greet("Scala developer")
  }
}
