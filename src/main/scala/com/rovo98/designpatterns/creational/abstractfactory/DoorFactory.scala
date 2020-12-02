package com.rovo98.designpatterns.creational.abstractfactory

trait DoorFactory {
  def makeDoor: Door
  def makeFittingExpert: DoorFittingExpert
}
