package com.rovo98.designpatterns.structural.decorator

class MilkCoffee(protected val coffee: Coffee) extends Coffee {

  override def getCost: Double = coffee.getCost + 2

  override def getDescription: String = s"${coffee.getDescription}, milk"
}
