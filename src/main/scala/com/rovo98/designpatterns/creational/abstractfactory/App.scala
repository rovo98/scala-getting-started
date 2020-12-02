package com.rovo98.designpatterns.creational.abstractfactory

object App {
  def main(args: Array[String]): Unit = {
    val woodenDoor = WoodenDoorFactory.makeDoor
    val carpenter = WoodenDoorFactory.makeFittingExpert
    println(woodenDoor.getDescription)
    println(carpenter.getDescription)

    val ironDoor = IronDoorFactory.makeDoor
    val welder = IronDoorFactory.makeFittingExpert
    println(ironDoor.getDescription)
    println(welder.getDescription)
  }
}
/*
in plain words
> A factory of factories; a factory that groups the individual but related/dependent
> factories together without specifying their concrete classes.

When to use?
When there are interrelated dependencies with not-that-simple creation logic involved.
 */
