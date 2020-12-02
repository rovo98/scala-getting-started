package com.rovo98.sgs.designpatterns.structural.decorator

class WhipCoffee(protected val coffee: Coffee) extends Coffee {
  override def getCost: Double = coffee.getCost + 5

  override def getDescription: String = s"${coffee.getDescription}, whip"
}
