package com.rovo98.sgs.designpatterns.behavior.template

/*
Programmatic example
Imagine we have a build tool that helps us test, lint, build, generate build reports (i.e.
code coverage reports, linting report etc) and deploy our app on the test server.
 */
object App {
  def main(args: Array[String]): Unit = {
    val androidBuilder = new AndroidBuilder
    androidBuilder.build()

    println()
    val iosBuilder = new IosBuilder
    iosBuilder.build()
  }
}

/*
In plain words
Template method defines the skeleton of how certain algorithm could be performed but defers
the implementation of those steps to the children classes.

Wikipedia says
In software engineering, the template method pattern is a behavioral design pattern that
defines the program skeleton of an algorithm in an operation, deferring some steps to subclasses
. It lets one redefine certain steps of an algorithm without changing the algorithm's structure
 */


// Base class specifies the skeleton for the build algorithm
trait Builder {
  // template method
  def build(): Unit = {
    this.test()
    this.lint()
    this.assemble()
    this.deploy()
  }

  def test()
  def lint()
  def assemble()
  def deploy()
}

// concrete implementations
class AndroidBuilder extends Builder {
  override def test(): Unit = println("Running android tests")

  override def lint(): Unit = println("Linting the android code")

  override def assemble(): Unit = println("Assembling the android code")

  override def deploy(): Unit = println("Deploying android build to server")
}

class IosBuilder extends Builder {
  override def test(): Unit = println("Running ios tests")

  override def lint(): Unit = println("Linting the ios code")

  override def assemble(): Unit = println("Assembling the ios build")

  override def deploy(): Unit = println("Deploying the ios build to server")
}