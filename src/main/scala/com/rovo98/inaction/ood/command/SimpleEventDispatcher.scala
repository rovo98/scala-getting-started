package com.rovo98.inaction.ood.command

import scala.collection.mutable.ArrayBuffer

class SimpleEventDispatcher(private var listeners: ArrayBuffer[EventListener]
                           ) extends EventDispatcher {

  /**
   * Dispatching the event to all registered event listeners.
   */
  override def dispatch(event: CommandEvent): Unit = {
    listeners.foreach(listener => if (listener.canHandle(event)) listener.listen(event))
  }

  def registerListener(listener: EventListener): Unit = {
    listeners += listener
  }
}

object SimpleEventDispatcher {
  def apply(listeners: ArrayBuffer[EventListener]): SimpleEventDispatcher = new SimpleEventDispatcher(listeners)
}