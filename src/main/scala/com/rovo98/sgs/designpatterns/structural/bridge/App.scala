package com.rovo98.sgs.designpatterns.structural.bridge

object App {
  def main(args: Array[String]): Unit = {
    val darkTheme = new DarkTheme
    val lightTheme = new LightTheme
    val about = new About(darkTheme)
    val careers = new Careers(lightTheme)

    println(about.getContent)
    println(careers.getContent)
  }
}
/*
In plain words
> Bridge pattern is about preferring composition over inheritance.
Implementation details are pushed from a hierarchy to another object with a separate hierarchy.
 */
