package com.rovo98.designpatterns.structural.adapter

object App {
  def main(args: Array[String]): Unit = {
    val hunter = new Hunter

    // hunting lions.
    val lion = new AfricanLion
    hunter.hunt(lion)

    val wildDog = new WildDog
    val wildDogAdapter = new WildDogAdapter(wildDog)
    // now the hunter can hunts wild dogs.
    hunter.hunt(wildDogAdapter)
  }
}
/*
In plain words
> Adapter pattern lets you wrap an otherwise incompatible object in an adapter to make it
compatible with another class.
 */
