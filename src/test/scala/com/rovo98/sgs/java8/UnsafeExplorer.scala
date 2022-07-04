package com.rovo98.sgs.java8

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import sun.misc.Unsafe
import sun.reflect.ReflectionFactory

class UnsafeExplorer extends AnyFunSuite with Matchers {

  val unsafe = {
    val unsafeConstructor = classOf[Unsafe].getDeclaredConstructor()
    unsafeConstructor.setAccessible(true)
    unsafeConstructor.newInstance()
  }

  test("getUnsafe-throw-SecurityException") {
    an[SecurityException] should be thrownBy {
      Unsafe.getUnsafe
    }
  }

  test("getUnsafeObject-through-reflection-1") {
    val theUnsafe = classOf[Unsafe].getDeclaredField("theUnsafe")
    theUnsafe.setAccessible(true)
    val unsafe = theUnsafe.get(null).asInstanceOf[Unsafe]
    unsafe.isInstanceOf[Unsafe] should be (true)
  }

  test("getUnsafeObject-through-reflection-2") {
    val unsafeConstructor = classOf[Unsafe].getDeclaredConstructor()
    unsafeConstructor.setAccessible(true)
    val unsafe = unsafeConstructor.newInstance()
    unsafe.isInstanceOf[Unsafe] should be (true)
  }

  test("testObjectCreation") {
    val instance = unsafe.allocateInstance(classOf[ClassWithExpensiveConstructor])
      .asInstanceOf[ClassWithExpensiveConstructor]

    instance.getValue should be (0)
  }


  test("testReflectionFactory") {
    val silentConstructor = ReflectionFactory.getReflectionFactory
      .newConstructorForSerialization(classOf[ClassWithExpensiveConstructor], classOf[Object].getConstructor())
    silentConstructor.setAccessible(true)
    silentConstructor.newInstance()
      .asInstanceOf[ClassWithExpensiveConstructor].getValue should be (0)
  }

  test("testDirectIntArray") {
    val maximum = Integer.MAX_VALUE + 1
    val directIntArray = new DirectIntArray(maximum)
    directIntArray.setValue(0L, 10)
    directIntArray.setValue(maximum, 20)
    directIntArray.getValue(0L) should be (10)
    directIntArray.getValue(maximum) should be (20)
    directIntArray.destroy()
  }
}
