package com.rovo98.sgs.designpatterns.behavior.visitor

/*
Programmatic Example
A zoo simulation where we have several different kinds of animals and we have to make them Sound.
Let's translate this using visitor pattern
 */
object App {
  def main(args: Array[String]): Unit = {
    val monkey = new Monkey
    val lion = new Lion
    val dolphin = new Dolphin

    val speak = new SpeakOperation
    val jump = new JumpOperation

    monkey.accept(speak)
    monkey.accept(jump)

    lion.accept(speak)
    lion.accept(jump)

    dolphin.accept(speak)
    dolphin.accept(jump)
  }
}
/*
In plain words
Visitor pattern let's you add further operations to objects without having to modify them.

Wikipedia says
In object-oriented programming and software engineering, the visitor design pattern is a way of
separating an algorithm from an object structure on which it operates. A practical result of
this separation is the ability to add new operations to existing object structures without
modifying those structures. It is one way to follow the open/closed principle.
 */

// implementations for the animals
class Monkey {
  def shout(): Unit = println("Ooh oo aa aa!")
  def accept(operation: Operation): Unit = operation.visitMonkey(this)
}
class Lion {
  def roar(): Unit = println("Roaaar!")
  def accept(operation: Operation): Unit = operation.visitLion(this)
}
class Dolphin {
  def speak(): Unit = println("Tuut tuttu tuutt!")
  def accept(operation: Operation): Unit = operation.visitDolphin(this)
}

// visitor
trait Operation {
  def visitMonkey(monkey: Monkey)
  def visitLion(lion: Lion)
  def visitDolphin(dolphin: Dolphin)
}

class SpeakOperation extends Operation {
  override def visitMonkey(monkey: Monkey): Unit = monkey.shout()

  override def visitLion(lion: Lion): Unit = lion.roar()

  override def visitDolphin(dolphin: Dolphin): Unit = dolphin.speak()
}

class JumpOperation extends Operation {
  override def visitMonkey(monkey: Monkey): Unit = println("Jumped 20 feet high! on to the tree!")

  override def visitLion(lion: Lion): Unit = println("Jumped 7 feet! Back on the ground!")

  override def visitDolphin(dolphin: Dolphin): Unit = println("Walked on water a little and disappeared")
}