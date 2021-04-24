package com.rovo98.scalatest.base

import org.scalatest.{Inside, Inspectors, OptionValues}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

/**
 * FlatSpec style unit test base class. Every unit test class should extend this class.
 * @author rovo98
 */
abstract class UnitSpec extends AnyFlatSpec with should.Matchers with OptionValues with Inside with Inspectors
