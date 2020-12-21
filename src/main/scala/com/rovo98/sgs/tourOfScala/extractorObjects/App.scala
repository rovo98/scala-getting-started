package com.rovo98.sgs.tourOfScala.extractorObjects

object App {
  def main(args: Array[String]): Unit = {
    // extractor object usage
    val customerID1 = CustomerID("Sukyoung") // calling CustomerID.apply(
    customerID1 match {
      case CustomerID(name) => println(name) // unapply -> calling CustomerID.unapply(customerID1)
      case _ => println("Could not extract a CustomerID")
    }

    val customer2ID = CustomerID("Nico")
    // equivalent to val name = CustomerID.unapply(customer2ID).get
    val CustomerID(name) = customer2ID
    println(s"extracted name from customer2ID-> $name")

    val CustomerID(name2) = "rovo98--asdfasdfasdf"
    println(s"matched customerID name -> $name2.")

    // NOTICE: if there is no match, a scala.MatchError is thrown
    val CustomerID(name3) = "-asdfasdfasdf"
    println(name3)

    /*
    unapply 方法的返回值必须是以下类型：
    1. 如果是一个 test，则返回一个 Boolean, 例如 case even()
    2. 如果是单个 T 的子类型，则返回 Option[T]
    3. 如果是多个返回值， ``T1, ..., Tn`` ，则需要将它们进行组合并返回 Option[T1, ..., Tn]
     */
  }
}
