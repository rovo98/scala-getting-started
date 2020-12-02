package com.rovo98.sgs.designpatterns.structural.bridge

class About(protected var theme: Theme) extends WebPage {
  override def getContent: String = "About page in " + theme.getColor
}
