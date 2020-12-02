package com.rovo98.sgs.tourOfScala.traits

trait Runner {
  def startRunning(): Unit = println("I'm running")
  def stopRunning(): Unit = println("Stopped running!")
}
