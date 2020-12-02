package com.rovo98.designpatterns.creational.prototype

class Sheep(var name: String,
            var category: String = "Mountain Sheep") extends DeepClone[Sheep] {
  override def toString = s"Sheep($name, $category)"

  override def deepClone: Sheep = new Sheep(this.name, this.category)
}

