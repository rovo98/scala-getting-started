package com.rovo98.sgs.designpatterns.creational.builder

class Burger(builder: BurgerBuilder) {
  protected var size: Int = builder.size
  protected var cheese: Boolean = builder.cheese
  protected var pepperoni: Boolean = builder.pepperoni
  protected var lettuce: Boolean = builder.lettuce
  protected var tomato: Boolean = builder.tomato

  override def toString = s"Burger($size, $cheese, $pepperoni, $lettuce, $tomato)"
}

class BurgerBuilder(var size: Int,
                    var cheese: Boolean = false,
                    var lettuce: Boolean = false,
                    var tomato: Boolean = false,
                    var pepperoni: Boolean = false) {
  def addPepperoni(): BurgerBuilder = {
    this.pepperoni = true
    this
  }
  def addLettuce(): BurgerBuilder = {
    this.lettuce = true
    this
  }
  def addCheese(): BurgerBuilder = {
    this.cheese = true
    this
  }

  def addTomato(): BurgerBuilder = {
    this.tomato = true
    this
  }

  def build(): Burger = new Burger(this)
}
