package com.rovo98.sgs.tourOfScala.singletonObjects

case class Email(username: String, domainName: String)

object Email {
  def fromString(emailString: String): Option[Email] = {
    emailString.split('@') match {
      case Array(a, b) => Some(new Email(a, b))
      case _ => None
    }
  }
}
