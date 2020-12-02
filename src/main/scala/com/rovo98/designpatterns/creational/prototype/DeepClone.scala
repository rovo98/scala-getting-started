package com.rovo98.designpatterns.creational.prototype

trait DeepClone[A] { self: A =>
  def deepClone: A
}
