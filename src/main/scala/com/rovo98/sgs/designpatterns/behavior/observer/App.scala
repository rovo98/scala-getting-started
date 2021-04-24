package com.rovo98.sgs.designpatterns.behavior.observer

import scala.collection.mutable

/*
Programmatic example

A good example would be the job seekers where they subscribe to some job posting site and they are notified whenever
there is a matching job opportunity
 */
object App {
  def main(args: Array[String]): Unit = {
    val johnDoe = new JobSeeker("John Doe")
    val janeDoe = new JobSeeker("Jane Doe")
    val kaneDoe = new JobSeeker("Kane Doe")

    // Create publisher and attach subscribers
    val jobBoard = new JobBoard
    jobBoard.subscribe(johnDoe)
    jobBoard.subscribe(janeDoe)
    jobBoard.subscribe(kaneDoe)

    // Add a new job and see if subscribers get notified
    jobBoard.addJob(JobPost("Software Engineer"))
  }
}
/*
In plain words
Defines a dependency between objects so that whenever an object changes its state, all its dependents are notified.

Wikipedia says
The observer pattern is a software design pattern in which an object, called the subject, maintains a list of its
dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.
 */

case class JobPost(title: String)

class JobSeeker(name: String) {
  def notify(jobPost: JobPost): Unit = {
    println(s"${this.name} has been notified of a new posting: ${jobPost.title}")
  }
}
class JobBoard {
  private val _subscribers: mutable.ListBuffer[JobSeeker] = mutable.ListBuffer.empty

  def subscribe(jobSeeker: JobSeeker): Unit = this._subscribers += jobSeeker

  def unsubscribe(jobSeeker: JobSeeker): Unit = this._subscribers -= jobSeeker

  def addJob(jobPosting: JobPost): Unit  = this._subscribers.foreach(_.notify(jobPosting))
}
