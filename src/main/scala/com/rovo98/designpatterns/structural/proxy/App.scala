package com.rovo98.designpatterns.structural.proxy

object App {
  def main(args: Array[String]): Unit = {
    val door = new SecuredDoor(new LabDoor)
    door.open("invalid")

    door.open("$ecr@t")
    door.close()
  }
}
/*
In plain words
> Using the proxy pattern, a class represents the functionality of another class.
 */
