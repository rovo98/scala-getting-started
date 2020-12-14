package com.rovo98.sgs.tourOfScala.patternmatching

import scala.util.Random

object PatternMatchingDemo {
  def main(args: Array[String]): Unit = {

    // basic usage.
    val x: Int = Random.nextInt(10)
    println(x match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case _ => "other"
    })

    // Matching on case classes
    def showNotification(notification: Notification): String = {
      notification match {
        case Email(sender, title, _) => s"You got an email from $sender with title: $title."
        case SMS(number, message) => s"You got an SMS from $number! Message: $message."
        case VoiceRecording(name, link) => s"You received a Voice Recording from $name! Click the link -> $link."
      }
    }

    val someSms = SMS("12345", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

    println(showNotification(someSms))
    println(showNotification(someVoiceRecording))

    // Pattern guards
    def showImportantNotification(notification: Notification, importPeopleInfo: Seq[String]): String = {
      notification match {
        case Email(sender, _, _) if importPeopleInfo.contains(sender) =>
          s"You got an email from special someone!"
        case SMS(number, _) if importPeopleInfo.contains(number) =>
          "You got an SMS from special someone!"
        case other => showNotification(other)
      }
    }

    val importPeopleInfo = Seq("867-5309", "jenny@gmail.com")
    val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
    val importantSms = SMS("867-5309", "I'm here! Where are you?")

    println()
    println(showImportantNotification(someSms, importPeopleInfo))
    println(showImportantNotification(someVoiceRecording, importPeopleInfo))
    println(showImportantNotification(importantEmail, importPeopleInfo))

    println(showImportantNotification(importantSms, importPeopleInfo))

    // Matching on type only
    def goIdle(device: Device) = device match {
      case p: Phone => p.screenOff
      case c: Computer => c.screenSaverOn
    }
    println("matching on type only...")
    println(goIdle(Phone("Android")))
    println(goIdle(Computer("Mac")))

    // Sealed classes demo
    def findPlaceToSit(piece: Furniture): String = piece match {
      case a: Couch => "Lie on the couch"
      case b: Chair => "Sit on the chair"
    }

    println()
    println(findPlaceToSit(Couch()))
    println(findPlaceToSit(Chair()))
  }
}

abstract class Notification

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification

abstract class Device

case class Phone(model: String) extends Device {
  def screenOff = "Turning screen off"
}

case class Computer(model: String) extends Device {
  def screenSaverOn = "Turning screen saver on..."
}

sealed abstract class Furniture
case class Couch() extends Furniture
case class Chair() extends Furniture