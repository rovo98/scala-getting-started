package com.rovo98.designpatterns.creational.factorymethod

class MarketingManager extends HiringManager {
  override protected def makeInterviewer(): Interviewer = {
    new CommunityExecutive()
  }
}
