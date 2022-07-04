package com.rovo98.inaction.ood.command

trait CommandEvent {
  /**
   * Event source
   */
  def source: String
}

trait EventDispatcher {
  /**
   * Dispatching the event to all registered event listeners.
   */
  def dispatch(event: CommandEvent)
}


trait EventListener {
  /**
   * Returns true if this listener can handle the given event
   */
  def canHandle(event: CommandEvent): Boolean

  def listen(event: CommandEvent): Unit
}

class UserChangedEvent extends CommandEvent {
  /**
   * Event source
   */
  override def source: String = "UserChangedEvent"
}

class UserEventListener extends EventListener {
  /**
   * Returns true if this listener can handle the given event
   */
  override def canHandle(event: CommandEvent): Boolean = event match {
      case _: UserChangedEvent => true
    }

  override def listen(event: CommandEvent): Unit = {
    println("UserChangedEvent triggered! Try to switch the user configuration.")
  }
}