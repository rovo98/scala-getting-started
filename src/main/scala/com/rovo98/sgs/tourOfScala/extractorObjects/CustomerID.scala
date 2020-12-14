package com.rovo98.sgs.tourOfScala.extractorObjects

import scala.util.Random

object CustomerID {
  def apply(name: String) = s"$name--${Random.nextLong}"

  def unapply(customerID: String): Option[String] = {
    val stringArray: Array[String] = customerID.split("--")
    if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
  }
}

/*
一个 extractor object 提取对象，是一个拥有 unapply 方法的对象，而 apply 方法则像一个 constructor，用于接收参数并创建一个对象
unapply 则接收一个相应的对象，并试图将它转换回参数形式。
 */