package com.rovo98.sgs.designpatterns.behavior.memento

/*
Programmatic Example
text editor keeps saving the state from time to time and that you can restore if you want.
 */
object App {
  def main(args: Array[String]): Unit = {
    val editor = new Editor

    // type some stuff
    editor.typing("This is the first sentence.")
    editor.typing("This is second.")

    // Save the state to restore to : This is the first sentence. This is second.
    val saved = editor.save()

    // Type some more
    editor.typing("And this is third.")

    // Output: Content before saving
    println(editor.getContent)

    // Restoring
    editor.restore(saved)

    println(editor.getContent)
  }
}

/*
In plain words
Memento pattern is about capturing and storing the current state of an object in a manner that it can be
restored later on in a smooth manner.

Wikipedia says
The memento pattern is a software design pattern that provides the ability to restore an object to its previous
state (undo via rollback)
 */


// memento object that will be able to hold the editor state
case class EditorMemento(content: String)

// editor i.e. originator that is going to use memento object
class Editor {
  private var _content: String = ""

  def typing(words: String): Unit =
    this._content = this._content.concat(" ").concat(words)

  def getContent: String = this._content

  def save(): EditorMemento = EditorMemento(this._content)

  def restore(memento: EditorMemento): Unit = this._content = memento.content
}
