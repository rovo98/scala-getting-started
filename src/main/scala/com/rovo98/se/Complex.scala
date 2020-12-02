package com.rovo98.se

class Complex(real: Double, imaginary: Double) {
  def re:Double = real
  def im:Double = imaginary

  override def toString: String = "" + re + (if (im > 0) "+" else "") + im + "i"
}
