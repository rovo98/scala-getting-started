package com.rovo98.sgs.tourOfScala.curring

object App {
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8)
    val res = numbers.sum // numbers.foldLeft(0)(_ + _)
    println(res)

    // 1. use case one
    def foldLeft1[A, B](as: List[A], b0: B, op: (B, A) => B): B = {
      var result = b0
      as foreach (x => result = op(result, x))
      result
    }

    //    def notPossible = foldLeft1(numbers, 0, _ + _)
    val firstWay = foldLeft1[Int, Int](numbers, 0, _ + _)
    println(firstWay)

    val secondWay = foldLeft1(numbers, 0, (a: Int, b: Int) => a + b)
    println(secondWay)

    def foldLeft2[A, B](as: List[A], b0: B)(op: (B, A) => B): B = {
      var result = b0
      as foreach (x => result = op(result, x))
      result
    }

    val possible = foldLeft2(numbers, 0)(_ + _)
    println(possible)

    //noinspection NotImplementedCode
    // 2. use case implicit parameters
    // 充当隐式参数使用，仅需将作隐式参数放入隐式参数列表中即可
    def execute(args: Int)(implicit ec: scala.concurrent.ExecutionContext) = ???

    // 3. use case Partial application
    // 当一个方法调用时使用少量参数列表，并生成返回一个处理剩余参数列表的函数

    val numberFunc = numbers.foldLeft(List[Int]()) _

    val squares = numberFunc((xs, x) => xs :+ x * x)
    println(squares)
    val cubes = numberFunc((xs, x) => xs :+ x * x * x)
    println(cubes)
  }
}

/*
Methods may have multiple parameter lists.

Use cases
1. Drive Type Inference 驱动类型推断
2. implicit parameters 隐式参数列表
3. Partial application 部分应用
 */
