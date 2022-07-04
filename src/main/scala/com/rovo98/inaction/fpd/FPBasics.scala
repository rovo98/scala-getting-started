package com.rovo98.inaction.fpd

object FPBasics extends App {
  def lift3[A, B, C, D](f: (A, B, C) => D): (Option[A], Option[B], Option[C]) => Option[D] =
    (oa: Option[A], ob: Option[B], oc: Option[C]) =>
      for (a <- oa; b <- ob; c <- oc) yield f(a, b, c)

  import java.sql.DriverManager
  val createDbConnection = lift3(DriverManager.getConnection)
}
