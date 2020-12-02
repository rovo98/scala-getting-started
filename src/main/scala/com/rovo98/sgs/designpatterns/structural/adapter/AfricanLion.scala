package com.rovo98.sgs.designpatterns.structural.adapter

class AfricanLion extends Lion {
  override def roar(): Unit = {
    println("AfricanLion roar...")
  }
}
