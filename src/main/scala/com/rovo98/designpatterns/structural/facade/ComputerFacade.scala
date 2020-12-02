package com.rovo98.designpatterns.structural.facade

class ComputerFacade(protected val computer: Computer) {
  def turnOn(): Unit = {
    this.computer.electricShock()
    this.computer.makeSound()
    this.computer.showLoadingScreen()
    this.computer.bam()
  }
  def turnOff(): Unit = {
    this.computer.closeEveryThing()
    this.computer.pullCurrent()
    this.computer.sooth()
  }
}
