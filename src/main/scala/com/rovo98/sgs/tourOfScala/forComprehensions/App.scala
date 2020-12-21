package com.rovo98.sgs.tourOfScala.forComprehensions

/*
For 解析
comprehension 是一个 for (enumerators) yield e 表达式，其中 enumerators
是用分号 ; 分开的枚举器 enumerator

而一个 enumerator 可以用于生成新元素的 generator 或一个 filter 过滤器
 */
object App {
  def main(args: Array[String]): Unit = {
    // for comprehension example 1
    val userBase = List(
      User("Travis", 28),
      User("Kelly", 33),
      User("Jennifer", 44),
      User("Dennis", 23)
    )

    val twentySomethings =
      for (user <- userBase if user.age >= 20 && user.age < 30)
        yield user.name

    twentySomethings.foreach(name => println(name))
    /*
    一个 for 循环包含 yield 语句返回结果
    容器的类型取决于第一个 generator 的类型，如 user <- userBase 是一个 List
    而 yield user.name 返回的是一个 String，因此总体结果的返回值是 List[String]

    if user.age >= 20 && user.age < 30 是一个守位，用于过滤用户
     */

    // more complicated example using two generators
    def foo(n: Int, v: Int) =
      for (i <- 0 until n;
           j <- 0 until n if i + j == v)
      yield (i, j)

    foo(10, 10) foreach {
      case (i, j) =>
        println(s"($i, $j)")
    }
    /*
    以上例子，使用了两个 generator
    获取从 0 到 n - 1 中，所有加和等于 v 的数对，作为 tuple 返回
     */

    // Note
    /*
    sequence comprehensions 序列解析不仅可用于 List
    它可应用于任何支持 withFilter、map 和 flatMap 操作的数据类型
     */
    /*
    可在解析式中忽略 yield 关键字，这种情况下，解析式会返回 Unit
    在需要产生副作用时，该情况较有用
     */
    def fooWithSideEffects(n: Int, v: Int): Unit =
    for (i <- 0 until n;
         j <- 0 until n if i + j == v)
      println(s"($i,$j)")

    fooWithSideEffects(10, 10)
  }
}

case class User(name: String, age: Int)
