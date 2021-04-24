package com.rovo98.sgs.designpatterns.behavior.chainofresponsibility

sealed abstract class Account (balance: Int, name: String) {
  private var successor: Account = _
  def setNext(account: Account): Unit = this.successor = account

  def pay(amountToPay: Int): Unit = {
    if (this.canPay(amountToPay)) {
      println(s"Paid $amountToPay using ${this.name}!")
    } else if (this.successor != null) {
      println(s"Cannot pay using ${this.name}. Proceeding...")
      this.successor.pay(amountToPay)
    } else {
      println("None of the accounts have enough balance")
    }
  }
  def canPay(amount: Int): Boolean = this.balance >= amount
}


// several payment implementations.[processors]
class Bank(balance: Int, name: String)  extends Account(balance, name) {
  def this(balance: Int) = {
    this(balance, "bank")
  }
}
class Paypal(balance: Int, name: String) extends Account(balance, name) {
  def this(balance: Int) = {
    this(balance, "paypal")
  }
}

class Bitcoin(balance: Int, name: String) extends Account(balance, name) {
  def this(balance: Int) = {
    this(balance, "bitcoin")
  }
}
