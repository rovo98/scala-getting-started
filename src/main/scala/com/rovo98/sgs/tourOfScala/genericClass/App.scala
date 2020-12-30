package com.rovo98.sgs.tourOfScala.genericClass

object App {
  def main(args: Array[String]): Unit = {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    println(stack.pop()) // prints 2
    println(stack.pop()) // prints 1

    // 2. 上面的例子 stack 只能存储 Int 类型，若泛型是一个拥有子类型的超类型的话，stack 将可存储所有子类型

    val stack1 = new Stack[Fruit]
    val apple = new Apple
    val banana = new Banana

    stack1.push(apple)
    stack1.push(banana)

    /*
    Variance 变体是复杂类型的子类型与其组件的子类型的关系的相关性

    Scala 支持变体类型参数注解，用于表示 covariant 共变
      contravariant 逆变
      invariant 不变（不使用任何参数类型注解描述）

      class Foo[+A] // a covariant class
      class Foo[-A] // a contravariant class
      class Foo[A] // a invariant class
*/
    def printAnimalNames(animals: List[Animal]): Unit = {
      animals.foreach {
        animal => println(animal.name)
      }
    }

    val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
    val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))
    printAnimalNames(cats)
    printAnimalNames(dogs)
  }
}

sealed class Fruit

class Apple extends Fruit

class Banana extends Fruit


/*
e.g. class List[+T] 协变 T，表示两个类型 A 和 B, 若 B 是 A 的子类型
则 List[B] 是 List[A] 的子类型

这可使用让我直观地表示泛型的子类型关系
 */
abstract class Animal {
  def name: String
}

case class Cat(name: String) extends Animal

case class Dog(name: String) extends Animal

/*
Scala 标准库中有一个 sealed abstract class List[+A]，A 是协变的
则 List[Cat]， List[Dog] 是 List[Animal] 的子类型
 */
