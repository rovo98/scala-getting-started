package com.rovo98.designpatterns.creational.factorymethod

object App {
  def main(args: Array[String]): Unit = {
    val devManager = new DevelopmentManager()
    devManager.takeInterview()
    val marketingManager = new MarketingManager()
    marketingManager.takeInterview()
  }
}
/*
in plain words
> It provides a way to delegate the instantiation logic to child classes

When to use?
Useful when there is some generic processing in a class but the required
sub-class is dynamically decided at runtime. Or putting it in other words,
when the client doesn't know what exact sub-class it might need.
 */
