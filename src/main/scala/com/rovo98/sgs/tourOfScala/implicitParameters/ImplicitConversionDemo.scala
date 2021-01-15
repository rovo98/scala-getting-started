package com.rovo98.sgs.tourOfScala.implicitParameters
import scala.language.implicitConversions

object ImplicitConversionDemo {
  def main(args: Array[String]): Unit = {
    println(List(1, 2, 3) <= List(4, 5))
  }

  Int
  implicit def list2ordered[A](x: List[A])(implicit elem2ordered: A => Ordered[A]): Ordered[List[A]] = (_: List[A]) => 1
  implicit def int2Integer(x: Int): Integer = java.lang.Integer.valueOf(x)
}
/*
Implicit conversions 隐式转换

一个从类型 S 到类型 T 的隐式转换由一个拥有函数类型为 s => T 的隐式值定义（implicit value）；或通过一个隐式方法。

 隐式转换的应用场景：
 1. 如果一个表达式 e 的类型为 S,且 S 不是该表达式所期望的类型 T；
 2. e.m ， e 的成员类型应是 S，但 m 并不是 S 类型。

 在第一种情况中，Scala 将查找能将表达式 e 转换成类型 T 的隐式转换。第二种情况，将查找能将 e 转换，且结果包含成员 m 的隐式转换。

 e.g. 若作用范围内存在隐式方法 List[A] => Ordered[List[A]] 或 Int => Ordered[Int], 则下面对两个 List[Int] 列表的操作是合法的

 List(1, 2, 3) <= List(4, 5)

 WARN:
 不加限制地使用隐式转换可能会陷入陷阱中，因此 Scala 编译器会在编译时警告隐式转换的定义

 如果想关闭该警告，可做以下操作：
 - 到定义隐式转换的作用域中导入 scala.language.implicitConversions
 - 执行编译时，使用 -language:implicitConversions 参数
 */
