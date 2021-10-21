package com.rovo98.sgs.tourOfScala.classUsage.beans

import scala.beans.{BeanProperty, BooleanBeanProperty}

// Equavalent to java pojo bean
class User {
  @BeanProperty
  var name: String = _
  @BooleanBeanProperty
  var valid: Boolean = _
}

case class UserCode(name: String, value: String)

class Class(name: String, id: Int)

object PojoExample {

}
