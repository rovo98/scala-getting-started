package com.rovo98.sgs.tourOfScala.traits

/**
 * trait 特质，是包含某些字段和方法的类型，有点类似于 java8 中的函数式接口，可拥有默认的方法实现。
 */
object TraitsUsageExample {
  def main(args: Array[String]): Unit = {
    val dog = new Dog("pippy")
    val cat  = new Cat("mki")

    dog.speak()
    cat.speak()
  }
}
