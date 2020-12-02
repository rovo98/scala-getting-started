package com.rovo98.sgs.designpatterns.structural.facade

class Computer {
  def electricShock(): Unit = println("Ouch!")

  def makeSound(): Unit = println("Beep beep!")

  def showLoadingScreen(): Unit = println("Loading...")

  def bam(): Unit = println("Ready to be used!")

  def closeEveryThing(): Unit = println("Bup bup bup buzzzz!")

  def sooth(): Unit = println("Zzzzz")

  def pullCurrent(): Unit = println("Haaah")
}
