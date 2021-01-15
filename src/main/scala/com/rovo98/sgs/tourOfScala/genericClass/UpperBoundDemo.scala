package com.rovo98.sgs.tourOfScala.genericClass

object UpperBoundDemo {
  def main(args: Array[String]): Unit = {

    val dogContainer = new PetContainer[UpperBoundDemoDog](new UpperBoundDemoDog)
    val catContainer = new PetContainer[UpperBoundDemoCat](new UpperBoundDemoCat)

    // this would not compile
//    val lionContainer = new PetContainer[UpperBoundDemoLion](new UpperBoundDemoLion)
  }
}
/*
类型上界 upper type bound T <: A 表示类型变量 T 是类型 A 的子类。
 */

abstract class UpperBoundDemoAnimal {
  def name: String
}

abstract class Pet extends UpperBoundDemoAnimal

class UpperBoundDemoCat extends Pet {
  override def name: String = "Cat"
}

class UpperBoundDemoDog extends Pet {
  override def name: String = "Dog"
}

class UpperBoundDemoLion extends UpperBoundDemoAnimal {
  override def name: String = "Lion"
}

class PetContainer[P <: Pet](p: P) {
  def pet: P = p
}
