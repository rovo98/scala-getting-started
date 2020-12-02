package com.rovo98.sgs.designpatterns.structural.proxy

class LabDoor extends Door {
  override def open(): Unit = println("Opening lab door")

  override def close(): Unit = println("Closing the lab door")
}
