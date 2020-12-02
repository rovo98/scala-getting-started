package com.rovo98.sgs.tourOfScala

object ExpressionUsage {
  def main(args: Array[String]): Unit = {
    println(1)
    println(1 + 1)
    println("Hello!")
    println("Hello, " + " world!")

    // 常量 Constants
    val x = 1 + 1
    println(x)

//    x = 3 // It is not allowed

    // 变量 variables
    var a = 1 + 1
    a = 3
    println(a)

    // 代码块 blocks
    println({
      val x = 1 + 1
      x + 1
    })

    //  函数 Functions
    val addOne = (x: Int) => x + 1
    println(addOne(1))
    val add = (x: Int, y: Int) => x + y
    println(add(1, 2))

    val getTheAnswer = () => 42
    println(getTheAnswer())

    // 方法 method
    def addMethod(x: Int, y: Int): Int = x + y
    println(addMethod(1, 2))

    // 可接受多个参数列表
    def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
    println(s"可接受多个参数列表的函数：${addThenMultiply(1, 2)(3)}.")

    // 没有参数
    def name: String = System.getProperty("user.name")
    println("Hello, " + name + "!")

    def getSquareString(input: Double): String = {
      val square = input * input
      square.toString
    }
    println(getSquareString(2.5))
  }
}
