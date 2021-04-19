package com.rovo98.sgs.designpatterns.behavior.state

/*
Programmatic example
Takes an example of text editor, it let's you change the state of text that is typed
i.e. if you have selected bold, it starts writing in bold, if italic then in italics etc.
 */
object App {
  def main(args: Array[String]): Unit = {
    val editor = new TextEditor(defaultTransform)
    editor.typing("First line")
    editor.setTransform(uppercase)
    editor.typing("Second line")
    editor.typing("Third line")
    editor.setTransform(lowercase)
    editor.typing("Fourth line")
    editor.typing("Fifth line")
  }

  //@formatter:off
  def uppercase(inputString: String): String = inputString.toUpperCase()
  def lowercase(inputString: String): String = inputString.toLowerCase()
  def defaultTransform(inputString: String): String = inputString
  //@formatter: on
}

class TextEditor(var transform: String => String) {
  def setTransform(transform: String => String): Unit = this.transform = transform

  def typing(words: String): Unit = println(this.transform(words))
}

/*
In plain words
It lets you change the behavior of a class when the state changes

Wikipedia says
The state pattern is a behavioral software design pattern that implements a
state machine in an object-oriented way. With the state pattern, a state machine
is implemented by implementing each individual state as a derived class of the state pattern
interface, and implementing state transitions by invoking methods defined by the pattern's superclass
. The state pattern can be interpreted as a strategy pattern which is able to switch the current
strategy pattern through invocations of methods defined in the pattern's interface.
 */
