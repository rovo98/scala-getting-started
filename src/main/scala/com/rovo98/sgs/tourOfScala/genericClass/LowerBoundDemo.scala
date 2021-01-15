package com.rovo98.sgs.tourOfScala.genericClass

object LowerBoundDemo {
  def main(args: Array[String]): Unit = {
    trait Bird
    case class AfricanSwallow() extends Bird
    case class EuropeanSwallow() extends Bird

    val africanSwallowList = ListNode[AfricanSwallow](AfricanSwallow(), Nil())
    val birdList: Node[Bird] = africanSwallowList
    birdList.prepend(EuropeanSwallow())
  }
}

/*
类型下界 B >: A 表示类型变量 B 是类型 A 的超类
 */

trait Node[+B] {
  def prepend[U >: B](elem: U): Node[U]
}

case class ListNode[+B](h: B, t: Node[B]) extends Node[B] {
  override def prepend[U >: B](elem: U): Node[U] = ListNode(elem, this)
  def head: B = h
  def tail: Node[B] = t
}

case class Nil[+B]() extends Node[B] {
  override def prepend[U >: B](elem: U): Node[U] = ListNode(elem, this)
}