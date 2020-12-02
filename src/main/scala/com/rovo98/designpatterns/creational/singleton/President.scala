package com.rovo98.designpatterns.creational.singleton

class President private() {
  def sayHello(): Unit = {
    println("hello, I am a president")
  }
}

object President {
  private var _instance:President = _

  def instance: President = {
    if (_instance == null)
      _instance = new President()
    _instance
  }
}
/*
Scala prefers to build immutable objects over mutable ones.
However, given that the Singleton often holds state, and that state tends to be immutable (after all
, a constant global is often a compile-time constant and therefore no reason to use Singleton at all)
, it is generally safe to assume that any singleton in scala will need to have some kind of concurrency
control around it just as any Java or other JVM-based language would.
 */