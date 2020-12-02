package com.rovo98.sgs.tourOfScala

object IdFactory {
  private var counter = 0
  def create(): Int = {
    counter += 1
    counter
  }
}

object SimpleObjectUsage {
  def main(args: Array[String]): Unit = {
    val newId: Int = IdFactory.create()
    print(newId)
    val newerId = IdFactory.create()
    print(newerId)
  }
}
