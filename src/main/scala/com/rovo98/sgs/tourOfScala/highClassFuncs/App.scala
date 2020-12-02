package com.rovo98.sgs.tourOfScala.highClassFuncs

object App {
  def main(args: Array[String]): Unit = {
    // Higher order functions take other functions as parameters or
    // return a function as a result.
    val salaries = Seq(20000, 70000, 40000)
    val doubleSalary = (x: Int) => x * 2
    val newSalaries1 = salaries.map(doubleSalary)

    println(newSalaries1)

    val newSalaries2 = salaries.map(x => x * 2)
    println(newSalaries2)

    val newSalaries3 = salaries.map(_ * 2)
    println(newSalaries3)


    val weeklyWeatherForecast = WeeklyWeatherForecast(Seq(11.5, 32.7))
    println(weeklyWeatherForecast.forecastInFahrenheit)


    // functions that return functions.
    def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
      val schema = if (ssl) "https://" else "http://"
      (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
    }

    val domainName = "www.example.com"

    def getURL = urlBuilder(ssl = true, domainName)
    val endpoint = "users"
    val query = "id=1"
    val url = getURL(endpoint, query)
    println(url)
  }
}

// coercing methods into functions
case class WeeklyWeatherForecast(temperatures: Seq[Double]) {
  private def convertCtoF(temp: Double): Double = temp * 1.8 + 32

  def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF)
}

// functions that accept functions.
object SalaryRaiser {
  def smallPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * 1.1)

  def greatPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * salary)

  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)
}
