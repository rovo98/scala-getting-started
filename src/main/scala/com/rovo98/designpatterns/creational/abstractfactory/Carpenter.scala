package com.rovo98.designpatterns.creational.abstractfactory

class Carpenter extends DoorFittingExpert {
  override def getDescription: String = "I can only fit wooden doors"
}
