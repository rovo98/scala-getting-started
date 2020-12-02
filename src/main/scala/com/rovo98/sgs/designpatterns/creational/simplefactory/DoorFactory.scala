package com.rovo98.sgs.designpatterns.creational.simplefactory

object DoorFactory {
  def makeDoor(width: Float, height: Float): Door = {
    new WoodenDoor(width, height)
  }
}
