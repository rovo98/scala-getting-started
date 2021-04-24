package com.rovo98.inaction.implicitconversion.typeclassimplicits

sealed trait Json

object Json {

  case class Str(s: String) extends Json

  case class Num(value: Double) extends Json

  case class List(items: Json*) extends Json

  // ... many more definitions

  def convertToJson[T: Jsonable](x: T): Json = {
    implicitly[Jsonable[T]].serialize(x)
  }

//  def convertToJson[T](x: T)(implicit converter: Jsonable[T]): Json = {
//    converter.serialize(x)
//  }


  def convertToJsonAndPrint[T: Jsonable](x: T): Unit = println(convertToJson(x))

  def convertMultipleItemsToJson[T: Jsonable](t: Array[T]): Array[Json] = t.map(convertToJson(_))

  def main(args: Array[String]): Unit = {
    val name = "rovo98"
    println(Json.convertToJson(name))
  }
}


