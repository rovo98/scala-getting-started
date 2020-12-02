package com.rovo98.designpatterns.structural.adapter

class Hunter {
  def hunt(lion: Lion): Unit = lion.roar()
}
