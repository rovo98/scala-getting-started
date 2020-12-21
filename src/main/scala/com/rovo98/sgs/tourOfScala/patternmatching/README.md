
# Pattern Matching

Pattern matching 模式匹配，是一种检查给定值是否匹配特定模式的机制。成功匹配后，还能将给定值解构成其对应的组成部分。
可以把它简单地看作是 java ``switch`` 的一个强化版，它同样可用于一系列 ``if/else`` 语句中。

## Syntax

一个匹配表达式，有一个值 value, ``match`` 关键字，以及至少一个 ``case`` 子句。

```scala
import scala.util.Random
val x: Int = Random.nextInt(10)

x match {
  case 0 => "zero"
  case 1 => "one"
  case _ => "other"
}
```

上例中，``val x`` 是一个从 0 到 10 的一个随机整数，``x`` 作为 ``match`` 操作符的左操作数，右边是拥有四个 cases 的一个表达式。
其中，最后一个 case ``_`` 表示匹配其他所有可能出现的 ``Int`` 值。

```scala
def matchTest(x: Int): String = x match {
  case 1 => "one"
  case 2 => "two"
  case _ => "other"
}
matchTest(3) // prints other
matchTest(1) // prints one
```

因为所有 cases 返回 ``String``，因此匹配表达式的类型为 ``String``，函数 ``matchTest`` 返回一个 ``String``。

## Matching on case classes

Case classes 在模式匹配中非常有用。

```scala
abstract class Notification
case class Email(sender: String, title: String, body: String) extends Notification
case class SMS(sender: String, message: String) extends Notification
case class VoiceRecording(contactName: String, link: String) extends Notification
```

``Notification`` 是一个拥有三个具体 case classes 的抽象类超类，现在便可以在这些 case classes 上使用模式匹配了。

```scala
def showNotification(notification: Notification): String =
  notification match {
    case Email(sender, title, _) => s"You got an email from $sender with title: $title"
    case SMS(number, message) => s"You got an SMS from $number! Message: $message"
    case VoiceRecording(name, link) => 
      s"You received a Voice Recording from $name! Click the link to hear it: $link"
  }
val someSms = SMS("12345", "Are you there?")
val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

println(showNotification(someSms)) 
println(showNotification(someVoiceRecording))
```

函数 ``showNotification`` 使用抽象类型 ``Notification`` 作为参数，然后对 ``Notification`` 类型进行匹配。

## Pattern guards

模式守卫， pattern guards 是简单的 boolean 表达式，主要用于使 cases 更加具体化。在模式之后使用 ``if <boolean expression>``。

```scala
def showImportNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
  notification match {
    case Email(sender, _, _) if importantPeopleInfo.contains(sender) =>
      "You got an email from special someone!"
    case SMS(number, _) if importantPeopleInfo.contains(number) => 
      "You got an SMS from special someone!"
    case other => showNotification(other)
  }
}
val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")

val someSms = SMS("123-4567", "Are you there?")
val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
val importantSms = SMS("867-5309", "I'm here! Where are you?")

println(showImportNotification(someSms, importantPeopleInfo))
println(showImportNotification((someVoiceRecording, importantPeopleInfo)))
println(showImportNotification(importantEmail, importantPeopleInfo))

println(showImportNotification(importantSms, importantPeopleInfo))
```

``case Email(sender, _, _) if importantPeopleInfo.contains(sender)`` ，该模式只有在 ``sender`` 是 ``importPeopleInfo`` 中的
一员时才会匹配成功。

### Matching on type only

你还可以想以下方式匹配类型：

```scala
abstract class Device
case class Phone(model: String) extends Device {
  def screenOff = "Turning screen off"
}
case class Computer(model: String) extends Device {
  def screenSaverOn = "Turning scree saver on..."
}

def goIdle(device: Device) = device match {
  case p: Phone => p.screeOff
  case c: Computer => c.screenSaverOn
}
```

``def goIdle`` 会根据 ``Device`` 的类型作出不同的行为。这在 case 需要根据模式 pattern 来调用方法时非常有用。并约定使用类型的第一个字母作为
case 的标识符。

### Sealed classes

Traits 和 classes 标记为 ``sealed`` （封闭的），则表示它的所有子类型均需要定义在同一个文件内。确保所有子类型均是已知的。

```scala
sealed abstract class Furniture
case class Couch() extends Furniture
case class Chair() extends Furniture

def findPlaceToSit(piece: Furniture): String = piece match {
  case a: Couch => "Lie on the couch"
  case c: Chair => "Sit on the chair"
}
```

这对于模式匹配是有用的，因为我们不需要 catch all 处理所有情况。
