package com.rovo98.inaction.ood.command

import scala.collection.mutable.ArrayBuffer

object CommandApp {
  def main(args: Array[String]): Unit = {
    val eventDispatcher = SimpleEventDispatcher(ArrayBuffer(new UserEventListener))
    eventDispatcher.dispatch(new UserChangedEvent)
  }
}
