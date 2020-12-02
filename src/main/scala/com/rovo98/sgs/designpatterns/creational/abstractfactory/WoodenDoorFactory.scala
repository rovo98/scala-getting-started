package com.rovo98.sgs.designpatterns.creational.abstractfactory

object WoodenDoorFactory extends DoorFactory {
  override def makeDoor: Door = new WoodenDoor()

  override def makeFittingExpert: DoorFittingExpert = new Carpenter()
}
