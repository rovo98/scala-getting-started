package com.rovo98.sgs.designpatterns.creational.abstractfactory

trait DoorFactory {
  def makeDoor: Door
  def makeFittingExpert: DoorFittingExpert
}
