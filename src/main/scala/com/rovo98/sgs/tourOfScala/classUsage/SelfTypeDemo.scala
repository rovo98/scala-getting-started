package com.rovo98.sgs.tourOfScala.classUsage

object SelfTypeDemo {
  def main(args: Array[String]): Unit = {

    val realBeyonce = new VerifiedTweeter("Beyonce")
    realBeyonce.tweet("Just spilled my glass of lemonade")
  }
}
/*
Self-types 自类型，是一种将 trait 混合进入另一 trait 的方法，即便该 trait 不直接 extends 另一 trait
 */

trait User {
  def username: String
}

trait Tweeter {
  this: User => // reassign this
  def tweet(tweetText: String): Unit = println(s"$username: $tweetText")
}

class VerifiedTweeter(val username_ : String) extends Tweeter with User {
  override def username: String = s"real $username_"
}
