package com.rovo98.inaction.implicitconversion.typeclassimplicits

trait Jsonable[T] {
  def serialize(t: T): Json
}

object Jsonable {

  implicit object StringJsonable extends Jsonable[String] {
    override def serialize(t: String): Json = Json.Str(t)
  }

  implicit object DoubleJsonable extends Jsonable[Double] {
    override def serialize(t: Double): Json = Json.Num(t)
  }

  implicit object IntJsonable extends Jsonable[Int] {
    override def serialize(t: Int): Json = Json.Num(t.toDouble)
  }

  implicit def SeqJsonable[T: Jsonable]: Jsonable[Seq[T]] = (t: Seq[T]) => {
    Json.List(t.map(implicitly[Jsonable[T]].serialize): _*)
  }
}
