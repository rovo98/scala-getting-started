package com.rovo98.sgs.designpatterns.structural.decorator

class SimpleCoffee extends Coffee {
  override def getCost: Double = 10

  override def getDescription: String = "Simple coffee"
}
