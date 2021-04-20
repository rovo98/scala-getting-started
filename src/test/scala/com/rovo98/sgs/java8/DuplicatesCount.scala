package com.rovo98.sgs.java8

import scala.collection.mutable
import scala.util.control.Breaks.{break, breakable}

object DuplicatesCount {

  def duplicatedCount(str: String): Int = str.groupBy(_.toLower).count(_._2.length > 1)

  // brute-force : O(n^2)
  def duplicateCount(str: String): Int = {
    var result = 0
    val transformedStr = str.toLowerCase()
    val characters = transformedStr.split("")
    val checkedSet = mutable.HashSet.empty[String]
    characters.foreach(c => {
      var count = 0
      breakable {
        if (!checkedSet.contains(c)) // iterates non-processed elems only
          for (i <- 0 until transformedStr.length) {
            if (c == "" + transformedStr.charAt(i)) count = count + 1
            if (count == 2) {
              result = result + 1
              checkedSet += c
              break
            }
          }
      }
    })
    result
  }
}
