package com.rovo98.sgs.tourOfScala.implicitParameters

import com.rovo98.sgs.tourOfScala.implicitParameters.ImplicitTest._

object ImplicitParametersUsage {
  def main(args: Array[String]): Unit = {

    println(sum(List(1, 2, 3)))
    println(sum(List("a", "b", "c")))
  }
  def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
    if (xs.isEmpty) m.unit
    else m.add(xs.head, sum(xs.tail))
}

/*
Implicit parameters 隐式参数

一个方法可以有一个隐式参数列表，通过 implicit 关键字在参数列表前声明

如果该参数列表中的参数没有传入，Scala 则会自动获取正确类型的隐式值，并传递进去。

Scala 查找隐式参数的方式可以大致分为以下两类：
- 首先，Scala 会查找从被调用隐式参数方法处能直接访问到的隐式定义及隐式参数；
- 接着，查找与隐式候选类型相关的所有伴生对象（companion objects）的隐式成员（implicit members）
 */

