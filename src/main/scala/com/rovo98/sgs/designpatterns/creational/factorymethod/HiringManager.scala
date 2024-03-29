package com.rovo98.sgs.designpatterns.creational.factorymethod

abstract class HiringManager {
  // Factory method
  protected def makeInterviewer(): Interviewer

  def takeInterview(): Unit = {
    this.makeInterviewer().askQuestions()
  }
}
