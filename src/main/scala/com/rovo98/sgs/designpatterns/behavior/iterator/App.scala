package com.rovo98.sgs.designpatterns.behavior.iterator

import scala.collection.mutable

object App {
  def main(args: Array[String]): Unit = {
    val stationList = new StationList
    stationList.addStation(RadioStation(89))
    stationList.addStation(RadioStation(101))
    stationList.addStation(RadioStation(102))
    stationList.addStation(RadioStation(103.2F))

    stationList.stations.foreach(station => println(station.frequency))

    stationList.removeStation(RadioStation(89))
  }
}
/*
In a plain words
It presents a way to access the elements of an object without exposing the underlying
 presentation.

 Wikipedia says
 In object-oriented programming, the iterator pattern is a design pattern in which an
 iterator is used to traverse a  container and access the container's elements.
 The iterator pattern decouples algorithms from containers in some cases, algorithms
 are necessary container-specify and thus cannot be decoupled.
 */

private[iterator] case class RadioStation(frequency: Float)

private[iterator] class StationList {
  private val _stations = mutable.ArrayBuffer[RadioStation]()

  def stations = this._stations
  def addStation(station: RadioStation):Unit = this._stations += station
  def removeStation(toRemove: RadioStation): Unit = this._stations -= toRemove
}
