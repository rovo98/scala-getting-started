package com.rovo98.sgs.designpatterns.structural.adapter

class Hunter {
  def hunt(lion: Lion): Unit = lion.roar()
}
