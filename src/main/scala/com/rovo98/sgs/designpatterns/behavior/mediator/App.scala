package com.rovo98.sgs.designpatterns.behavior.mediator

import java.util.Date

/*
Programmatic Example
a chat room (i.e. mediator) with users (i.e. colleagues) sending messages to each other.
 */
object App {
  def main(args: Array[String]): Unit = {
    val mediator = new ChatRoom
    val john = new ChatUser("John Doe", mediator)
    val jane = new ChatUser("Jane Doe", mediator)

    john.send("Hi there!")
    jane.send("Hey!")
  }
}

/*
In plain words
Mediator pattern adds a third object (called mediator) to control the interaction between two objects (called colleagues)
. It helps reduce the coupling between the classes communicating with each other. Because now they don't need to have
the knowledge of each other's implementation.

Wikipedia says
In software engineering, the mediator pattern defines an object that encapsulates how a set of objects interact.
This pattern is considered to be a behavioral pattern due to the way it can alter the program's running behavior.
 */


// Mediator
class ChatRoom {
  def showMessage(user: ChatUser, message: String):Unit = {
    val time = new Date()
    println(s"$time[${user.name}]: $message")
  }
}
// colleagues
class ChatUser(val name: String, chatMediator: ChatRoom) {
  def send(msg: String): Unit = {
    this.chatMediator.showMessage(this, msg)
  }
}