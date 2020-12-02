package com.rovo98.sgs.designpatterns.creational.simplefactory

object App {
  def main(args: Array[String]): Unit = {
    // make me a door of 100x200
    val door = DoorFactory.makeDoor(100, 200)
    println("Width: " + door.getWith)
    println("Height: " + door.getHeight)
    val door2 = DoorFactory.makeDoor(50, 200)
    println(door2)
  }
}

/*
in plain words:
> Simple factory simply generates an instance for client without
> exposing any instantiation logic to the client.

Use case:
When creating an object is not just a few assignments and involves some logic, it makes sense to put
it in a dedicated factory instead of repeating the same code everywhere.
 */
