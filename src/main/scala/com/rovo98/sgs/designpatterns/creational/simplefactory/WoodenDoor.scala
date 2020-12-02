package com.rovo98.sgs.designpatterns.creational.simplefactory

class WoodenDoor(width: Float, height: Float) extends Door {

  override def getWith: Float = width

  override def getHeight: Float = height
}
