package com.rovo98.sgs.tourOfScala.traits.demo02

import scala.collection.mutable.ArrayBuffer

class Cat(val name: String) extends Pet
class Dog(val name: String) extends Pet

object Animals {
  def main(args: Array[String]): Unit = {
    val dog = new Dog("Harry")
    val cat = new Cat("Sally")

    val animals = ArrayBuffer.empty[Pet]
    animals.append(dog)
    animals.append(cat)
    animals.foreach(pet => println(pet.name))
  }
}

/*
特质 trait 用于在类之间共享程序接口和字段，类似于 java 8 中的接口。

特质不能被实例化，因此它们没有参数
但凡需要特质的地方，都可以由该特质的子类型来替换；

dog 和 cat 之所以能调用 name，是因为它在特质 Pet 中的子类型中得到了实现。
 */
