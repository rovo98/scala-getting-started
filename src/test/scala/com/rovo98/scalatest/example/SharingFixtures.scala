package com.rovo98.scalatest.example

import java.io.{File, FileWriter}
import java.util.UUID.randomUUID
import java.util.concurrent.ConcurrentHashMap

import com.rovo98.scalatest.example.DbServer.{Db, createDb, removeDb}
import org.scalatest.{Failed, Outcome}
import org.scalatest.flatspec.AnyFlatSpec

import scala.collection.mutable.ListBuffer

class SharingFixtures extends AnyFlatSpec {
  def fixture = {
    new {
      val builder = new StringBuilder("ScalaTest is ")
      val buffer = new ListBuffer[String]
    }
  }

  trait Builder {
    val builder = new StringBuilder("ScalaTest is ")
  }
  trait Buffer {
    val buffer = ListBuffer("ScalaTest", "is")
  }

  "Testing" should "be easy" in {
    val f = fixture
    f.builder.append("easy!")
    assert(f.builder.toString() === "ScalaTest is easy!")
    assert(f.buffer.isEmpty)
    f.buffer += "sweet"
  }

  it should "be fun" in {
    val f = fixture
    f.builder.append("fun!")
    assert(f.builder.toString === "ScalaTest is fun!")
    assert(f.buffer.isEmpty)
  }

  // Instantiating fixture-context objects
  // This test needs the StringBuilder fixture
  "Testing" should "be productive" in new Builder {
    builder.append("productive!")
    assert(builder.toString === "ScalaTest is productive!")
  }
  // This test needs the ListBuffer[String] fixture
  "Test code" should "be readable" in new Buffer {
    buffer += "readable!"
    assert(buffer === List("ScalaTest", "is", "readable!"))
  }
  // This test needs both the StringBuilder and ListBuffer
  it should "be clear and concise" in new Builder with Buffer {
    builder.append("clear!")
    buffer += "concise!"
    assert(builder.toString === "ScalaTest is clear!")
    assert(buffer === List("ScalaTest", "is", "concise!"))
  }

  // Overriding withFixture(NoArgTest)
  override def withFixture(test: NoArgTest): Outcome = {
    super.withFixture(test) match {
      case failed: Failed =>
        val currDir = new File(".")
        val fileNames = currDir.list()
        info("Dir snapshot: " + fileNames.mkString(", "))
        failed
      case other => other
    }
  }
  "This test" should "succeed" in  {
    assert(1 + 1 === 2)
  }
  it should "fail" in {
    assert(1 + 1 === 3)
  }

  // Calling loan-fixture methods - if you need to both pass a fixture object into a test and perform
  // cleanup at the end of the test
  def withDataBase(testCode: Db => Any): Unit = {
    val dbName = randomUUID.toString
    val db = createDb(dbName) // create fixture
    try {
      db.append("ScalaTest is ")
      testCode(db)            // "loan" the fixture to the test
    } finally removeDb(dbName)
  }

  def withFile(testCode: (File, FileWriter) => Any): Unit = {
    val file = File.createTempFile("hello", "world") // create the fixture
    val writer = new FileWriter(file)
    try {
      writer.write("ScalaTest is ") // set up the fixture
      testCode(file, writer) // "loan" the fixture to the test
    } finally writer.close()
  }
  // This test needs the file fixture
  "Testing" should "be productive" in withFile { (file, writer) =>
    writer.write("productive")
    writer.flush()
    assert(file.length() === 24)
  }
  // This test needs the database fixture
  "Test code" should "be readable" in withDataBase { db =>
    db.append("readable!")
    assert(db.toString === "ScalaTest is readable!")
  }
  // This test needs both the file and database
  it should "be clear and concise" in withDataBase { db =>
    withFile {(file, writer) => // loan-fixture methods compose
      db.append("clear!")
      writer.write("concise!")
      writer.flush()
      assert(db.toString === "ScalaTest is clear!")
      assert(file.length === 21)
    }
  }
}

object DbServer { // Simulating a database server
  type Db = StringBuffer
  private val databases = new ConcurrentHashMap[String, Db]
  def createDb(name: String): Db = {
    val db = new StringBuffer
    databases.put(name, db)
    db
  }
  def removeDb(name: String): Unit = {
    databases.remove(name)
  }
}
