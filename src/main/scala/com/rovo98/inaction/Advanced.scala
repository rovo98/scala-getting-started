package com.rovo98.inaction

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {
  // lazy evaluation
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so lazy!")
    32
  }

  val eagerValue = lazyValueWithSideEffect + 1
  // useful in infinite collections

  // "pseudo-collections": Option, Try
  def methodWhichCanReturnNull(): String = "hello, Scala"
  val anOption = Option(methodWhichCanReturnNull()) // Some("hello, Scala")
  // option = "collection" which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }
  // map, flatMap, filter

  def methodWhichCanThrowException(): String = throw new RuntimeException

  try {
    methodWhichCanThrowException()
  } catch {
    case e: Exception => println("defensive code should define here.")
  }

  val aTry = Try(methodWhichCanThrowException())
  // a Try = "collection" with either a value if code went well, or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(value) => s"I have obtained a valid string: $value"
    case Failure(exception) => s"error happened: $exception"
  }

  /**
   * Evaluate something on another thread
   * (asynchronous programming)
   */
  val aFuture = Future({
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value.")
    67
  })
  Thread.sleep(2000)

  // future is a "collection" which contains a value when it's evaluated
  // future is composable with map, flatMap, and filter.

  /**
   * Implicits basics
   */
  // #1 implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt: Int = 46
  println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt)

  // #2 implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven: Boolean = n % 2 == 0
  }
  println(23.isEven)
}
