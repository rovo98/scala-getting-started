package com.rovo98.sgs.tourOfScala.traits

trait Greeter {
  def greet(name: String): Unit = {
    println("Hello, " + name + "!")
  }
}
