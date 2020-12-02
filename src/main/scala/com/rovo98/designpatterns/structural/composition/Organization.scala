package com.rovo98.designpatterns.structural.composition
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class Organization {
  protected var employees: mutable.ArrayBuffer[Employee] = new ArrayBuffer[Employee]()

  def addEmployee(employee: Employee):Unit = this.employees += employee

  def getNetSalaries: Float = employees.map(_.getSalary).sum
}
