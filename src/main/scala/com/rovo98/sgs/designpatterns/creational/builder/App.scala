package com.rovo98.sgs.designpatterns.creational.builder

object App {
  def main(args: Array[String]): Unit = {
    val burger = new BurgerBuilder(14)
      .addPepperoni()
      .addLettuce()
      .addTomato()
      .build()
    println(burger.toString)
  }
}
/*
in plain words
> Allows you to create different flavors of an object while avoiding
constructor pollution. Useful when there could be several flavors of an object.
Or when there are a lot of steps involved in creation of an object.

When to use?
When there could be several flavors of an object and to avoid the constructor telescoping.
The key difference from the factory pattern is that; factory pattern is to be used when the creation is a one step
process while builder pattern is to be used when the creation is a multi step process.
 */
