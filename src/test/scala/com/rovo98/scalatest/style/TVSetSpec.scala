package com.rovo98.scalatest.style

import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec

sealed class TVSet {
  private var on: Boolean = false
  def isOn: Boolean = on
  def pressPowerButton(): Unit = {
    on = !on
  }
}

// FeatureSpec is recommended to use for writing acceptance testing cases..

class TVSetSpec extends AnyFeatureSpec with GivenWhenThen {
  info(
    """As a TV set owner
      |I want to be able to turn the TV on and off
      |So I can watch TV when I want
      |And save energy when I'm not watching TV
      |""".stripMargin)

  Feature("TV power button") {
    Scenario("User presses power button when TV is off") {
      Given("a TV set that is switched off")
      val tv = new TVSet
      assert(!tv.isOn)

      When("the power button is pressed")
      tv.pressPowerButton()

      Then("the TV should switch on")
      assert(tv.isOn)
    }
    Scenario("User presses power button when TV is on") {
      Given("a TV set that is switched on")
      val tv = new TVSet
      tv.pressPowerButton()
      assert(tv.isOn)

      When("the power button is pressed")
      tv.pressPowerButton()

      Then("the TV should switch off")
      assert(!tv.isOn)
    }
  }
}
