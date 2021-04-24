package com.rovo98.scalatest.example

import org.scalatest.Inside.inside
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

case class Address(street: String, city: String, state: String, zip: String)

case class Name(first: String, middle: String, last: String)

case class Record(name: Name, address: Address, age: Int)

class InsideUsage extends AnyFlatSpec with Matchers {

  "Nested object graph" should "be easy checked" in {
    val rec = Record(
      Name("Sally", "Anna", "Jones"),
      Address("25 Main St", "Los Angeles", "CA", "12345"),
      38
    )

    inside (rec) { case Record(name, address, age) =>
      inside (name) { case Name(first, mid, last) =>
        first should be ("Sally")
        mid should be ("Anna")
        last should be ("Jones")
      }
      inside (address) { case Address(street, city, state, zip) =>
        street should startWith ("25")
        city should endWith ("Angeles")
        state should equal ("CA")
        zip should be ("12345")
      }
      age should be < 99
    }
  }
}
