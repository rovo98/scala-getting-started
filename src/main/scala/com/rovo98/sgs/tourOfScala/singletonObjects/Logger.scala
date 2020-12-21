package com.rovo98.sgs.tourOfScala.singletonObjects

object Logger {
  def info(message: String): Unit = println(s"INFO: $message")
}

object LoggerUsage {
  def main(args: Array[String]): Unit = {
    val testClass = new Test
    println(testClass)
  }
}

class Project(name: String, daysToComplete: Int)
class Test {
  val project1 = new Project("TPS Reports", 1)
  val project2 = new Project("Website redesign", 5)
  Logger.info("Created projects")
}
