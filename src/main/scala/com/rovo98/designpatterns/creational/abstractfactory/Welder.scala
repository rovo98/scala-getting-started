package com.rovo98.designpatterns.creational.abstractfactory

class Welder extends DoorFittingExpert {
  override def getDescription: String = "I can only fit iron doors"
}
