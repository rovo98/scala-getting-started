package com.rovo98.sgs.tourOfScala

/**
 * Scala 中有一种特殊的类，叫做 case class 样例类。
 *
 * 默认情况下，样例类一般用于不可变对象，并且可作值比较。
 */
object CaseClassUsage {
  def main(args: Array[String]): Unit = {
    case class Point(x: Int, y: Int)

    val point = Point(1, 2)
    val anotherPoint = Point(1, 2)
    val yetAnotherPoint = Point(2, 2)

    // 使用样例类作值进行比较
    def comparePoints(p: Point, ap: Point): Unit = {
      if (p == ap)
        println(point + " and " + anotherPoint + " are the same.")
      else
        println(point + " and " + anotherPoint + " are different.")
    }
    comparePoints(point, anotherPoint)
    comparePoints(point, yetAnotherPoint)
  }
}
