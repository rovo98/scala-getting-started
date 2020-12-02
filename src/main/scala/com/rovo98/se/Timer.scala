package com.rovo98.se

object Timer {
  def oncePerSecond(callback: () => Unit): Unit = {
    while (true) {
      callback()
      Thread sleep 1000
    }
  }

  /**
   * Driver the program to test the methods above.
   * @param args command-line arguments
   */
  def main(args: Array[String]): Unit = {
    oncePerSecond(() => println("time files like an arrow..."))
  }
}