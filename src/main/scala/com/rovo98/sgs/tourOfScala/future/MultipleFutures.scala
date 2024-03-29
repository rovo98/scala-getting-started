package com.rovo98.sgs.tourOfScala.future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object MultipleFutures {
  def main(args: Array[String]): Unit = {
    // use this to determine the "delta time" below
    val startTime = currentTime

    // (a) create three futures
    val aaplFuture = getStockPrice("AAPL")
    val amznFuture = getStockPrice("AMZN")
    val googFuture = getStockPrice("GOOG")
    // (b) get a combined result in a for-expression
    val result: Future[(Double, Double, Double)] = for {
      aapl <- aaplFuture
      amzn <- amznFuture
      goog <- googFuture
    } yield (aapl, amzn, goog)

    // (c) do whatever you need to do with the results
    result.onComplete {
      case Success(x) =>
        val totalTime = deltaTime(startTime)
        println(s"In Success case, time delta: ${totalTime}")
        println(s"The stock prices are: $x")
      case Failure(e) => e.printStackTrace()
    }

    // To keep the JVM's main thread alive.
    sleep(5000)
  }


  def sleep(time: Long): Unit = Thread sleep time

  // a simulated web service
  def getStockPrice(stockSymbol: String): Future[Double] = Future {
    val r = scala.util.Random
    val randomSleepTime = r.nextInt(3000)
    println(s"For $stockSymbol, sleep time is $randomSleepTime")
    val randomPrice = r.nextDouble() * 1000
    sleep(randomSleepTime)
    randomPrice
  }

  def currentTime= System.currentTimeMillis()
  def deltaTime(t0: Long) = currentTime - t0
}
