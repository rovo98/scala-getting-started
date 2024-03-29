package com.rovo98.sgs.designpatterns.structural.composition

//noinspection DuplicatedCode
class Developer(protected var name: String,
                protected var salary: Float) extends Employee {
  protected var roles: Array[String] = _

  override def getName: String = name

  override def setSalary(salary: Float): Unit = this.salary = salary

  override def getSalary: Float = salary

  override def getRoles: Array[String] = roles
}
