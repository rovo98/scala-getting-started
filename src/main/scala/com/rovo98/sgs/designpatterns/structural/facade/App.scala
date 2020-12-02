package com.rovo98.sgs.designpatterns.structural.facade

object App {
  def main(args: Array[String]): Unit = {
    val computer = new ComputerFacade(new Computer)
    computer.turnOn()
    computer.turnOff()
  }
}
/*
In plain words
> Facade pattern provides a simplified interface to a complex subsystem.
 */
