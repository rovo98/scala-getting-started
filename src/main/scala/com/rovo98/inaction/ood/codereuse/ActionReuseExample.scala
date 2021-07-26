package com.rovo98.inaction.ood.codereuse

import java.sql.{Connection, PreparedStatement, ResultSet, SQLException}

import scala.collection.mutable.ListBuffer

/**
 * Simple examples for demonstrating Action Code reuse
 */
object ActionReuseExample {
  def main(args: Array[String]): Unit = {
    // invocations
    val users1:List[User] = readAllUsers()
    val users2:List[User] = readUserOfStatus("1")
  }

  def readAllUsers(): List[User] = {
/*
    var connection: Connection = null
    val sql = "select * from users"
    val users: ListBuffer[User] = ListBuffer()
    try {
      connection = openConnection();
      val statement: PreparedStatement = connection.prepareStatement(sql)
      val result: ResultSet = statement.executeQuery()
      while (result.next()) {
        val user = User(result.getString("name"))
        users += user
      }
      result.close()
      statement.close()
    } catch {
      case e: SQLException =>
        e.printStackTrace()
    } finally {
      // ignore for now
    }
    users.toList
*/
    readUserList("select * from users", Array())
  }

  def readUserOfStatus(status: String): List[User] = {
/*
    var connection: Connection = null
    val sql = "select * from users where status = ?"
    val users: ListBuffer[User] = ListBuffer()

    try {
      connection = openConnection()
      val statement: PreparedStatement = connection.prepareStatement(sql)
      statement.setString(1, status)
      val result: ResultSet = statement.executeQuery()
      while (result.next()) {
        val user = User(result.getString("name"))
        users += user
      }
      result.close()
      statement.close()
    } catch {
      case ex: SQLException =>
        ex.printStackTrace()
    } finally {
      // ignore for now
    }
    users.toList
*/
    readUserList("select * from users where status = ?", Array(status))
  }

  // Action reuse
  private def readUser(result: ResultSet): User = {
    User(result.getString("name"))
  }
  // Parameterized Actions
  private def readUserList(sql: String, parameters: Array[String]): List[User] = {
    var connection: Connection = null
    val users: ListBuffer[User] = ListBuffer()
    try {
      connection = openConnection()
      val statement: PreparedStatement = connection.prepareStatement(sql)
      for (i <- 0 to parameters.length) statement.setString(i, parameters(i))
      val result: ResultSet = statement.executeQuery()
      while (result.next()) {
        users += readUser(result)
      }
      result.close()
      statement.close()
    } catch {
      case ex: SQLException => // ignore for now
    } finally {
      // ignore for now
    }
    users.toList
  }


  def openConnection(): Connection = ???
}

sealed case class User(username: String)
