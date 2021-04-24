package com.rovo98.sgs.designpatterns.behavior.strategy

import scala.util.control.Breaks.{break, breakable}

object App {
  def main(args: Array[String]): Unit = {
    val longDataset = Array(1, 5, 4, 3, 2, 8)
    val shortDataset = Array(1, 5, 4)
    sort(longDataset)
    sort(shortDataset)

    println("sorted:")
    println(s"longDataset: ${longDataset.mkString("Array(", ", ", ")")}")
    println(s"shortDataset: ${shortDataset.mkString("Array(", ", ", ")")}")
  }

  def sort(dataset: Array[Int]): Unit = {
    if (dataset.length > 5)
      quickSort(dataset)
    else bubbleSort(dataset)
  }

  def bubbleSort(dataset: Array[Int]): Unit = {
    println("Sorting with bubble sort...")
    val len = dataset.length - 1
    var flag = true
    for (i <- 0 until len; if flag) {
      flag = false
      for (j <- 0 until len - i) {
        if (dataset(j) > dataset(j + 1)) {
          swap(dataset, j, j+1)
          flag = true
        }
      }
    }
  }

  private def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    arr(i) ^= arr(j)
    arr(j) ^= arr(i)
    arr(i) ^= arr(j)
  }

  def quickSort(dataset: Array[Int]): Unit = {
    println("Sorting with quick sort...")
    helper(dataset, 0, dataset.length - 1)

    def helper(arr: Array[Int], low: Int, high: Int): Unit = {
      var l = low
      var h = high
      while (l < h) {
        val pi = partition(arr, l, h)
        if (pi - l < h - pi) {
          helper(arr, l, pi - 1)
          l = pi + 1
        } else {
          helper(arr, pi + 1, h)
          h = pi - 1
        }
      }
    }

    def partition(arr: Array[Int], low: Int, high: Int): Int = {
      if (low > high) throw new IllegalArgumentException(s"invalid arguments. given low is greater than high: $low > $high")
      var i = low + 1
      var j = high
      val povit = arr(low)
      breakable {
        while (true) {
          breakable {
            while (arr(i) < povit) {
              i = i + 1
              if (i == high) break
            }
          }
          breakable {
            while (arr(j) > povit) {
              j = j - 1
              if (j == low) break
            }
          }
          if (i > j) break
          swap(arr, i, j)
        }
      }
      if (j > low) swap(arr, low, j)
      j
    }
  }
}

/*
In a plain words
Strategy pattern allows you to switch the algorithm or strategy based upon the situation

Wikipedia says
In computer programming, the strategy patter (also known as the policy pattern) is a behavioural
software design pattern that enables an algorithm's behavior to be selected at runtime.
 */


