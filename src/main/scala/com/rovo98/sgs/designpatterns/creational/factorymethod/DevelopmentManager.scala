package com.rovo98.sgs.designpatterns.creational.factorymethod

class DevelopmentManager extends HiringManager {
  override protected def makeInterviewer(): Interviewer = {
    new Developer()
  }
}
