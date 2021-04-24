package com.rovo98.sgs.designpatterns.behavior.command

object App {
  def main(args: Array[String]): Unit = {
    // client code
    val bulb = new Bulb()
    val turnOn = new TurnOnCommand(bulb)
    val turnOff = new TurnOffCommand(bulb)

    val remote = new RemoteControl
    remote.submit(turnOn) // Bulb has been lit
    remote.submit(turnOff) // Darkness
  }
}

/*
in plain words
Allows you to encapsulate actions in objects. The key idea behind this pattern is to
provide the means to decouple client from receiver.

Wikipedia says
In object-oriented programming, the command pattern is a behavioral design pattern
is which an object is used to encapsulate all information needed to perform an action
or trigger an event at a later time. This information includes the method name,
the object that owns the method and values for the method parameters.
 */

// Receiver
class Bulb {
  def turnOn() = println("Bulb has been lit")
  def turnOff() = println("Darkness")
}

// command interface
sealed trait Command {
  def execute()
  def undo()
  def redo()
}

class TurnOnCommand(bulb: Bulb) extends Command {
  override def execute(): Unit = this.bulb.turnOn()

  override def undo(): Unit = this.bulb.turnOff()

  override def redo(): Unit = this.execute()
}
class TurnOffCommand(bulb: Bulb) extends Command {
  override def execute(): Unit = this.bulb.turnOff()

  override def undo(): Unit = this.bulb.turnOn()

  override def redo(): Unit = this.execute()
}

// Invoker, whom the client will interact to process any commands.
class RemoteControl {
  def submit(command: Command): Unit = command.execute()
}
