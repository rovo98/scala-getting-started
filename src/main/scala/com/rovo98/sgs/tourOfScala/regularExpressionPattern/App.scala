package com.rovo98.sgs.tourOfScala.regularExpressionPattern

object App {
  def main(args: Array[String]): Unit = {
    // 任何 String 都能使用 .r 方法转换成正则表达式

    val numberPattern = "[0-9]".r
    numberPattern.findFirstMatchIn("awesomepassword") match {
      case Some(_) => println("Password OK")
      case None => println("Password must contain a number")
    }

    val keyValPattern = "([0-9a-zA-Z- ]+): ([0-9a-zA-Z#()/. ]+)".r

    val input =
      """
        |background-color: #A03300;
        |background-image: url(img/header100.img);
        |background-position: top center;
        |background-repeat: repeat-x;
        |background-size: 2160px 108px;
        |margin: 0;
        |height: 108px;
        |width: 100%;
        |""".stripMargin
        for (patternMatch <- keyValPattern.findAllMatchIn(input)) {
          println(s"key: ${patternMatch.group(1)} value: ${patternMatch.group(2)}")
        }
  }
}
