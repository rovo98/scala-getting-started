package com.rovo98.sgs.designpatterns.structural.flyweight

object App {
  def main(args: Array[String]): Unit = {
    val teaMaker = new TeaMaker
    val shop = new TeaShop(teaMaker)

    shop.takeOrder("less sugar", 1)
    shop.takeOrder("more milk", 2)
    shop.takeOrder("without sugar", 5)

    shop.serve()
  }
}

/*
In plain words
> It is used to minimize memory usage or computational expenses by sharing
as much as possible with similar objects.
 */
