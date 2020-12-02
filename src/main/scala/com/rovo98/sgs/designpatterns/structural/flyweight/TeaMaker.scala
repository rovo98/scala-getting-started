package com.rovo98.sgs.designpatterns.structural.flyweight

import scala.collection.mutable

// Anything that will be cached is flyweight.
// types of tea here will be flyweight
case class KaraTea()

class TeaMaker {
  private val availableTea: mutable.HashMap[String, KaraTea] = new mutable.HashMap[String, KaraTea]()

  def make(preference: String): KaraTea = {
    if (!this.availableTea.contains(preference)) {
      this.availableTea.put(preference, new KaraTea)
    }
    this.availableTea.get(preference).orNull
  }
}
