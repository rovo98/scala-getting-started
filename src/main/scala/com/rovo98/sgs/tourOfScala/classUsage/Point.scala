package com.rovo98.sgs.tourOfScala.classUsage

class Point {
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def x: Int = _x
  def x_(newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning()
  }

  def y: Int = _y
  def y_(newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning()
  }

  private def printWarning(): Unit = println("WARNING: Out of bounds")
}
class AnotherPoint(var x: Int = 0, var y:Int = 0)

object PointClassExample {
  def main(args: Array[String]): Unit = {
    val point1 = new Point

    point1.x_(99)
    point1.y_(101)
    println(s"point: x -> ${point1.x}, y -> ${point1.y}.")

    val anotherPoint = new AnotherPoint(1, 2)
    println(anotherPoint.x)
  }
}
