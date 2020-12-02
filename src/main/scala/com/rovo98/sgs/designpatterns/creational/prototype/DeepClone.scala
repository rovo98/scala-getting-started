package com.rovo98.sgs.designpatterns.creational.prototype

trait DeepClone[A] { self: A =>
  def deepClone: A
}
