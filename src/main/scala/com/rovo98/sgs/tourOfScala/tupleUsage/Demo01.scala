package com.rovo98.sgs.tourOfScala.tupleUsage

/*
在 Scala 中，元组是一个可容纳不同类型的元素的类。元组是不可变的

当我们需要从函数返回多个值时，元组就可以派上用场

NOTICE: Scala 中的元组包含一系列类，如 Tuple2, Tuple3, 一直到 Tuple22。
 */
object Demo01 {
  def main(args: Array[String]): Unit = {
    // 1. 创建一个元组的方式
    val ingredient = ("Sugar", 25): (String, Int)
    // 2. 访问元组中的元素
    println(s"ingredient 1st: ${ingredient._1}") // Sugar
    println(s"ingredient 2nd: ${ingredient._2}") // 25
    // 3. 解构元组，类似于 python 好像
    val (name, quantity) = ingredient
    println(name)
    println(quantity)

    // 4. 元组还可以用于模式匹配 pattern match

    val planeDistanceFromSun = List(("Mercury", 57.9), ("Venus", 108.2),
      ("Earth", 149.6), ("Mars", 227.9), ("Jupiter", 778.3))
    planeDistanceFromSun.foreach {
      case ("Mercury", distance) => println(s"Mercury is $distance millions km far from Sun")
      case p if p._1 == "Venus" => println(s"Venus is ${p._2} km far from Sun")
      case p if p._1 == "Earth" => println(s"Earth is ${p._2} km far from Sun")
      case _ => println("Too far...")
    }
  }
}
/*
类型 Unit 的值 () 在概念上与类型 Tuple0 的值相同。Tuple0 只能有一个值，因为它没有元素

用户有时可能会在 元组和 case 类之间难以选择。通常情况下，如果元素具有更多含义，则首选 case 类。
 */
