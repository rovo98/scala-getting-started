package com.rovo98.sgs.tourOfScala.traits

class Cat(name: String) extends Speaker with TailWagger with Runner {
  override def speak(): String = "Meow"

  override def startRunning(): Unit = println("Yeah...I don't run")

  override def stopRunning(): Unit = println("No need to stop")
}
