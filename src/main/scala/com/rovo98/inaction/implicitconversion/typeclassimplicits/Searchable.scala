package com.rovo98.inaction.implicitconversion.typeclassimplicits

import com.rovo98.inaction.implicitconversion.typeclassimplicits.Searchable.searchUri

// type class pattern
trait Searchable[T] {
  def uri(obj: T): String
}

case class Customer(taxCode: String, name: String, surname: String)
case class Policy(policyId: String, description: String)

object Searchable {
  implicit val searchableCustomer: Searchable[Customer] = (customer: Customer) => s"/customers/${customer.taxCode}"
  implicit val searchablePolicy: Searchable[Policy] = (policy: Policy) => s"/policy/${policy.policyId}"

  def searchUri[S: Searchable](obj: S): String = implicitly[Searchable[S]].uri(obj)
}

object SearchableUsageEx {
  def main(args: Array[String]): Unit = {
    val customer = Customer("16018", "rovo98", "test")

    println(searchUri(customer))
  }
}