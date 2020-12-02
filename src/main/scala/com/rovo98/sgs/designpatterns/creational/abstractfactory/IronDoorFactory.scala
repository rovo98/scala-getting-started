package com.rovo98.sgs.designpatterns.creational.abstractfactory

object IronDoorFactory extends DoorFactory {
  override def makeDoor: Door = new IronDoor

  override def makeFittingExpert: DoorFittingExpert = new Welder
}
