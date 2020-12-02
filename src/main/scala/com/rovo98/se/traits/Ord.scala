package com.rovo98.se.traits

trait Ord {
  def < (that: Any): Boolean
  def <= (that: Any): Boolean = (this < that) || (this == that)
  def > (that: Any): Boolean = !(this <= that)
  def >= (that: Any): Boolean = !(this < that)
}
