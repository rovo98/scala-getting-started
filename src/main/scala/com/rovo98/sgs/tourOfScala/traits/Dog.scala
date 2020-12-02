package com.rovo98.sgs.tourOfScala.traits

class Dog(name: String) extends Speaker with TailWagger with Runner {
  override def speak(): String = "Woof!"
}
