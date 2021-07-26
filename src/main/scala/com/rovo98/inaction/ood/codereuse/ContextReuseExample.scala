package com.rovo98.inaction.ood.codereuse

import java.io.{FileInputStream, IOException, InputStream}


/**
 * A simple example for demonstrating Context code reuse.
 *
 * When looking for code in your projects that are suitable for context reuse,
 * look for this pattern of actions:
 *  - general action before
 *  - special action
 *  - general action after
 *
 *  Note: If you would like more than one plugin point in a context(one context consists of many smaller
 *  steps and you want each step of the context to be customizable)
 *  -> Uses Template method will better
 */
object ContextReuseExample {
  def main(args: Array[String]): Unit = {
    val inputStream: FileInputStream = new FileInputStream("myFile")
    new StreamProcessorContext()
      .processStream(inputStream, (input: Int) => println(input))

    val reader: StreamToStringReader = new StreamToStringReader
    new StreamProcessorContext()
      .processStream(inputStream, reader)
    println(reader.getBuffer.toString)
  }

  def printStream(inputStream: InputStream): Unit = {
    if (inputStream == null) return
    val exception: IOException = null
    try {
      var character: Int = inputStream.read()
      while (character != -1) {
        println(character)
        character = inputStream.read()
      }
    } finally
      try {
        inputStream.close()
      } catch {
        case e: IOException =>
          if (exception == null) throw e
      }
  }

  def readStream(inputStream: InputStream): String = {
    val buffer: StringBuffer = new StringBuffer()
    if (inputStream == null) return buffer.toString
    val exception: IOException = null
    try {
      var character: Int = inputStream.read()
      while (character != -1) {
        buffer.append(character)
        character = inputStream.read()
      }
      buffer.toString
    } finally {
      try {
        inputStream.close()
      } catch {
        case ex: IOException =>
          if (exception == null) throw ex
      }
    }
  }
}

// Context code reuse
// the plugin interface
trait StreamProcessor {
  def process(input: Int)
}

// the stream processing context class
class StreamProcessorContext {
  def processStream(inputStream: InputStream,
                    processor: StreamProcessor): Unit = {
    if (inputStream == null) return
    val exception: IOException = null
    try {
      var character: Int = inputStream.read()
      while (character != -1) {
        processor.process(character)
        character = inputStream.read()
      }
    } finally {
      try {
        inputStream.close()
      } catch {
        case ex: IOException =>
          if (exception == null) throw ex
      }
    }
  }
}


class StreamToStringReader extends StreamProcessor {
  private val buffer: StringBuffer = new StringBuffer()
  def getBuffer =  this.buffer
  override def process(input: Int): Unit = this.buffer.append(input)
}