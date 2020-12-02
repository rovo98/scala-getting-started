package com.rovo98.designpatterns.structural.flyweight
import scala.collection.mutable


class TeaShop(val teaMaker: TeaMaker) {

  private val orders: mutable.HashMap[Int, KaraTea] = new mutable.HashMap[Int, KaraTea]()

  def takeOrder(teaType: String, table: Int): Unit = {
    this.orders.put(table, this.teaMaker.make(teaType))
  }

  def serve(): Unit =
    orders.foreach(order => {
      println(s"Serving tea to table#${order._1}")
    })
}
