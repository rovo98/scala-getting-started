package com.rovo98.sgs.designpatterns.structural.adapter

class WildDogAdapter(var dog: WildDog) extends Lion {
  override def roar(): Unit = dog.bark()
}
