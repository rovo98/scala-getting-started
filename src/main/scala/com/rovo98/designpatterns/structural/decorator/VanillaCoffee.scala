package com.rovo98.designpatterns.structural.decorator

class VanillaCoffee(protected val coffee: Coffee) extends Coffee {
  override def getCost: Double = coffee.getCost + 3

  override def getDescription: String = s"${coffee.getDescription}, vanilla"
}
