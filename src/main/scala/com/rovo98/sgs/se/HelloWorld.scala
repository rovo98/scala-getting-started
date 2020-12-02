package com.rovo98.sgs.se

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    new Thread(() => {
      println("Hello world!")
    }).start()
    Thread sleep 2000
//    val es = Executors.newFixedThreadPool(10)
//    es.submit(() => {println("Hello world!")})
  }
}
