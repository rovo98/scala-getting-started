package com.rovo98.sgs.tourOfScala.genericClass

object AbstractTypeMembersDemo {
  def main(args: Array[String]): Unit = {

    def newIntSeqBuf(elem1: Int, elem2: Int): IntSeqBuffer =
      new IntSeqBuffer {
        override type T = List[U]
        override val element = List(elem1, elem2)
      }

    val buf = newIntSeqBuf(7, 8)
    println(s"length = ${buf.length}")
    println(s"content = ${buf.element}")

    def newIntSeqBufUsingParameterList(e1: Int, e2: Int): SeqBufferUsingParameterList[Int, Seq[Int]] =
      new SeqBufferUsingParameterList[Int, List[Int]] {
        override val element: List[Int] = List(e1, e2)
      }

    val buf2 = newIntSeqBufUsingParameterList(9, 10)
    println(s"buf2 length = ${buf2.length}")
    println(s"buf2 content = ${buf2.element}")
  }
}
/*
Abstract types 抽象类型，如 trait 或 abstract class 均可拥有其抽象类型成员，以让其具体实现类来决定实际类型

1. 抽象类型成员与类型参数列表的使用 是可以相互转换的, 当然也有不能转换的情况存在
 */

trait Buffer {
  type T
  val element: T
}

abstract class SeqBuffer extends Buffer {
  type U
  type T <: Seq[U]
  def length: Int = element.length
}

abstract class IntSeqBuffer extends SeqBuffer {
  type U = Int
}


trait BufferUsingParameterList[+T] {
  val element: T
}

abstract class SeqBufferUsingParameterList[U, +T <: Seq[U]] extends BufferUsingParameterList[T] {
  def length: Int = element.length
}
