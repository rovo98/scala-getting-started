package com.rovo98.sgs.designpatterns.structural.decorator

object App {
  def main(args: Array[String]): Unit = {
    val someCoffee = new SimpleCoffee
    println("simple coffee cost: " + someCoffee.getCost)
    println("simple coffee desc: " + someCoffee.getDescription)

    val milkCoffee = new MilkCoffee(someCoffee)
    println("milk coffee cost: " + milkCoffee.getCost)
    println("milk coffee desc: " + milkCoffee.getDescription)

    val whipCoffee = new WhipCoffee(someCoffee)
    println("whip coffee cost: " + whipCoffee.getCost)
    println("whip coffee desc: " + whipCoffee.getDescription)

    val vanillaCoffee = new VanillaCoffee(someCoffee)
    println("vanilla coffee cost: " + vanillaCoffee.getCost)
    println("vanilla coffee desc: " + vanillaCoffee.getDescription)
  }
}

/*
In plain words
> Decorator pattern lets you dynamically change the behavior of an object
at run time by wrapping them in an object of a decorator class.
 */
