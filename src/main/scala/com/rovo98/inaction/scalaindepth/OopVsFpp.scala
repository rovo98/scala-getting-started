package com.rovo98.inaction.scalaindepth

object OopVsFpp {
  def main(args: Array[String]): Unit = {
    // oop
    val cat = new Cat
    val bird = new Bird
    cat.catchBird(bird)
    cat.eat()


    // fpp
    //    val story = (catchBird _) andThen (eat _)
    //    story(new TCat, new TBird)
  }

  def catchBird(hunter: Cat, prey: Bird): Cat with Bird = ???

  def eat(consumer: Cat with Bird): Cat with FullTummy = ???
}

class Bird

class Cat {
  def catchBird(b: Bird): Unit = ???

  def eat(): Unit = ???
}

trait TCat

trait TBird

trait Catch

trait FullTummy