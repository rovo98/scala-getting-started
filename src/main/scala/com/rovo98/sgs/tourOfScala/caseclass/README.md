
# Case class

Case 与普通的类类似，但略有不同。 Case classes 非常适合用于不变 (immutable) 数据的建模。
能够很好地配合 pattern matching （模式匹配）一起使用。

## 1. Defining a case class

定义一个 case class 需要使用关键字 ``case class``，后接一个标识符，一个参数列表（可以为空）。

```scala
case class Book(isbn: String)
val frankenstein = Book("978-0486282114")
```

Notice: 实例化 ``Book`` case class 不需要使用 ``new`` 关键字，因为 case classes 默认均会有一个 ``apply``
方法来处理对象的创建。

当创建一个拥有参数的 case class 时，其所有参数均为 public ``val``。

```scala
case class Message(sender: String, recipient: String, body: String)
val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ca va?")

println(message1.sender) // prints guillaume@quebec.ca
message1.sender = "travis@washington.us" // this line does not compile
```

Notice: 上例中无法对 ``message1.sender`` 进行赋值，因为参数默认声明为 ``public val`` ，虽然 case classes 中
可以使用 ``var`` 的参数，但**不建议这么做**。

## 2. Copying

你可以简单地使用 ``copy`` 方法来对 case class 的实例进行浅拷贝（shadow copy），且能选择是否改变构造器的参数。

```scala
case class Message(sender: String, recipient: String, body: String) 
val message4 = Message("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")

message5.sender // travis@washington.us
message5.recipient // claire@bourgogne.fr
message5.body // Me zo o komz gant ma amezeg
```

