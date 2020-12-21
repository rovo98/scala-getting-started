package com.rovo98.sgs.tourOfScala.caseclass

object CaseClassSimpleUsage {
  def main(args: Array[String]): Unit = {
    case class Message(sender: String, recipient: String, body: String)

    val message1 = Message("rovo98@foxmail.com", "rovo984sff@gmail.com", "hello!")
    val message2 = message1.copy(sender = message1.recipient, recipient = "someone",
      body = message1.body + s" from ${message1.sender}")

    println(message2.sender)
    println(message2.recipient)
    println(message2.body)
  }
}
