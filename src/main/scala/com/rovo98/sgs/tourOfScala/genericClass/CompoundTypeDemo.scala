package com.rovo98.sgs.tourOfScala.genericClass

object CompoundTypeDemo {
  def main(args: Array[String]): Unit = {

  }

  // cloneAndReset 方法接收一个对象，克隆并重置它 clone and reset
  def cloneAndReset(obj: Cloneable with Resetable): Cloneable = {
    val cloned = obj.clone()
    obj.reset()
    cloned
  }
}

/*
复合类型 compound type: 有时，我们需要表示某类的类型为许多其他类的子类

 */

trait Cloneable extends java.lang.Cloneable {
  override def clone(): Cloneable = {
    super.clone().asInstanceOf[Cloneable]
  }
}
trait Resetable {
  def reset(): Unit
}


