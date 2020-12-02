package com.rovo98.sgs.designpatterns.structural.proxy

// proxy class for doors.
class SecuredDoor(protected val door: Door) {
  def open(password: String): Unit = {
    if (this.authenticate(password))
      this.door.open()
    else println("Big no! It ain't possible.")
  }
  def authenticate(password: String): Boolean = password.equals("$ecr@t")
  def close(): Unit = this.door.close()
}
