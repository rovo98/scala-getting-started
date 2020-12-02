package com.rovo98.designpatterns.structural.composition

object App {
  def main(args: Array[String]): Unit = {
    val john = new Developer("John Doe", 12000)
    val jane = new Designer("Jane Doe", 150000)

    val organization = new Organization
    organization.addEmployee(john)
    organization.addEmployee(jane)

    println("Net salaries: " + organization.getNetSalaries)
  }
}
/*
In plain words
> Composite pattern lets clients treat the individual objects in a uniform
> manner.
 */
