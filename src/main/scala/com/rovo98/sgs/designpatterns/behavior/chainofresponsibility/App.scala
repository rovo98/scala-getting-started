package com.rovo98.sgs.designpatterns.behavior.chainofresponsibility

object App {
  def main(args: Array[String]): Unit = {
    // Prepare a chain like below
    // bank.paypal.bitcoin
    // First priority back
    //  if bank can't pay then paypal
    //  if paypal can't pay then bit coin

    val bank = new Bank(100) // bank with balance 100
    val paypal = new Paypal(200) // paypal with balance 200
    val bitcoin = new Bitcoin(300) // bit coin with balance 300

    bank.setNext(paypal)
    paypal.setNext(bitcoin)

    // Try to pay using the first priority i.e. bank
    bank.pay(259)

    // Output will be
    // ===================
    // Cannot pay using bank. Proceeding...
    // Cannot pay using paypal. Proceeding...
    // Paid 259 using bitcoin!
  }
}

/*
In plain words

It helps building a chain of objects. Request enters from one end and keeps going
from object to object till it finds the suitable handler.

Wikipedia says

In object-oriented design, the chain of responsibility pattern is a design pattern
consisting of a source of command objects and a series of processing objects.
Each processing object contains logic that defines  the type of command objects
that is can handle the rest are passed to the next processing object in the chain.
 */
