package com.rovo98.sgs.designpatterns.structural.composition

trait Employee {
  def getName: String
  def setSalary(salary: Float)
  def getSalary: Float
  def getRoles: Array[String]
}
