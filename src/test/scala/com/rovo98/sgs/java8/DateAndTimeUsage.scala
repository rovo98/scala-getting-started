package com.rovo98.sgs.java8

import java.time.format.DateTimeFormatter
import java.time.temporal.{ChronoUnit, TemporalAdjusters}
import java.time.{Duration, LocalDate, LocalDateTime, LocalTime, OffsetDateTime, Period, ZoneId, ZoneOffset, ZonedDateTime}
import java.util.Date

/**
 * Java8 Date and Time APIs compared with original java.util.Date and their formatters.<br/><br/>
 * ref from: https://dzone.com/articles/java-8-date-and-time
 *
 */
object DateAndTimeUsage {
  def main(args: Array[String]): Unit = {
    val date1 = LocalDate.of(2018, 2, 13)
    val date2 = LocalDate.parse("2018-02-13")

    // 1. LocalDate, a date api that represents a date without time.
    println(s"date1 = $date1")
    println(s"date2 = $date2")

    // 2. LocalTime, a time representation without a date.
    val time1 = LocalTime.of(6, 30)
    val time2 = LocalTime.parse("06:30")

    println(s"time1 = $time1")
    println(s"time2 = $time2")

    val today = "2020-12-08"
    // 3. LocalDateTime, a combination of the previous two.
    val dateTime1 = LocalDateTime.of(2020, 12, 8, 17, 10, 30)
    val dateTime2 = LocalDateTime.parse(s"${today}T17:11:30")
    println(s"datetime1 = $dateTime1")
    println(s"datetime2 = $dateTime2")

    // conversions between: 1): LocalDateTime and LocalTime,
    //                      2): LocalDateTime and LocalDate
    // LocalDate to LocalDateTime
    val datetime3 = LocalDate.parse(today).atTime(LocalTime.parse("17:15"))
    println(s"\nconversion(LocalDate -> LocalDateTime): $datetime3")
    // LocalTime to LocalDateTime
    val datetime4 = LocalTime.parse("17:16").atDate(LocalDate.parse(today))
    println(s"conversion(LocalTime -> LocalDateTime): $datetime4")
    // LocalDateTime to LocalDate/LocalTime
    val date3 = LocalDateTime.parse(s"${today}T17:18:30").toLocalDate
    val time3 = LocalDateTime.parse(s"${today}T17:19:00").toLocalTime
    println(s"conversion(LocalDateTime -> LocalDate: $date3")
    println(s"conversion(LocalDateTime -> LocalTime: $time3")

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    println("DateFormatter Usage: parse -> " + LocalDateTime.parse(s"$today 12:34:00", formatter))

    // easily perform operations on date and time representations.
    val date4 = LocalDate.parse(today).plusDays(5)
    println(s"\ntoday plus 5 days: $date4")
    val date5 = LocalDate.parse(today).plus(3, ChronoUnit.MONTHS)
    println(s"today plus 3 months: $date5")

    val time4 = LocalTime.parse("17:25").minusMinutes(30)
    println(s"current time minus 30 minutes: $time4")
    val time5 = LocalTime.parse("17:26").minus(500, ChronoUnit.MILLIS)
    println(s"current time minus 500 mills: $time5")

    val datetime5 = LocalDateTime.parse(s"${today}T17:26").plus(Duration.ofHours(1))
    println(s"current datetime plus 2 hours: $datetime5")
    val date6 = LocalDate.parse(today).`with`(TemporalAdjusters.lastDayOfMonth())
    println(s"today using temporalAdjusters -> $date6")

    // Migration: Move java.util.Date to LocalDateTime
    val datetime6 = LocalDateTime.ofInstant(new Date().toInstant, ZoneId.systemDefault())
    println(s"\nmigration: move java.util.Date to LocalDateTime: $datetime6")

    // convert back to date
    // Uses Instant java8 time type
    // Since LocalDate, LocalTime & LocalDateTime do not contain any Zone or Offset information
    // , they represent the local date and/or time in a specified region.
    val now = new Date()
    val testDateTime = LocalDateTime.ofInstant(now.toInstant, ZoneId.systemDefault())

    val utilDate1 = Date.from(testDateTime.toInstant(ZoneOffset.ofHours(8)))
    val utilDate2 = Date.from(testDateTime.toInstant(ZoneId.systemDefault().getRules.getOffset(testDateTime)))
    println(s"utilDate now -> $now.")
    println(s"converting localDateTime to utilDate 1 : $utilDate1")
    println(s"converting localDateTime to utilDate 2 : $utilDate2")


    // Usage of Duration and Period
    // 1. To use Period when you need to know the difference in time between two LocalDate representations
    // 2. To use Duration when you're looking for a difference between representation that holds time information
    val period = Period.between(LocalDate.parse("2020-11-18"), LocalDate.parse(today))
    println(s"period usage: $period")
    val duration = Duration.between(LocalDateTime.parse(s"${today}T17:44"),
      LocalDateTime.parse("2020-11-28T11:00"))
    println(s"duration usage: $duration")


    // Period string representation based on ISO-8601 standard, PnYnMnD.
    // e.g. P1Y2M3D 表示 1 年 2 月 3 天
    println(Period.parse("P2M15D"))

    // Duration string representation: PnDTnHnMn.nS, PTnHnMn.nS
    val duration1 = Duration.between(LocalDateTime.parse(s"${today}T09:58"),
      LocalDateTime.parse("2020-12-09T10:00"))
    println(s"duration1 = $duration1, toHour -> ${duration1.toHours}")

    // Working with Zones and Offsets - ZonedDateTime and OffsetDateTime
    // ZonedDateTime 具备时区信息的 LocalDateTime
    // OffsetDateTime 具备时间偏移信息的 LocalDateTime
    val offsetDateTime1 = LocalDateTime.parse("2020-12-14T11:52").atOffset(ZoneOffset.ofHours(8))
    val offsetDateTime2 = OffsetDateTime.parse("2020-12-14T12:00+08:00")
    println(s"offsetDateTime1 -> $offsetDateTime1.")
    println(s"offsetDateTime2 -> $offsetDateTime2.")

    val zonedDateTime1 = LocalDateTime.parse("2020-12-14T14:00").atZone(ZoneId.of("+8"))
    val zonedDateTime2 = ZonedDateTime.parse("2020-12-14T14:01+08:00[Asia/Macau]")
    println(s"zonedDateTime1 -> $zonedDateTime1.")
    println(s"zonedDateTime2 -> $zonedDateTime2.")

    val timeInMacau = LocalDateTime.parse("2020-12-14T14:14").atZone(ZoneId.of("+8"))
    println(s"timeInMacau -> $timeInMacau.")
  }
}
