package com.rovo98.se.traits

class Date(y: Int, m: Int, d: Int) extends Ord {
  def year: Int = y

  def month: Int = m

  def day: Int = d

  override def toString: String = year + "-" + month + "-" + day

  override def equals(that: Any): Boolean =
    this.isInstanceOf[Date] && {
      val o = that.asInstanceOf[Date]
      o.day == day && o.month == month && o.year == year
    }

  override def <(that: Any): Boolean = {
    if (!that.isInstanceOf[Date]) {
      sys.error("Can not compare " + that + " and a Date")
    }
    val o = that.asInstanceOf[Date]
    (year < o.year) ||
      (year == o.year && (month < o.month ||
        (month == o.month && day < o.day)))
  }
}
