package com.rovo98.sgs.designpatterns.structural.bridge

class Careers(protected var theme: Theme) extends WebPage {
  override def getContent: String = "Careers page in " + theme.getColor
}
