package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTES= SECOND*60
const val HOUR= MINUTES*60
const val DAY= HOUR*24

fun Date.format(pattern : String = "HH:mm:ss dd.MM.yy") : String {
    val Date = SimpleDateFormat(pattern, Locale("ru"))
    return Date.format(this)
}

fun Date.add(value : Int, units: TimeUnits = TimeUnits.SECOND) : Date{
    var time = time
       time+=when(units) {
           TimeUnits.SECOND -> value* SECOND
           TimeUnits.MINUTE -> value* MINUTES
           TimeUnits.HOUR -> value* HOUR
           TimeUnits.DAY-> value* DAY
       }
    this.time=time
    return this
}
fun Date.humanizeDiff(date:Date = Date()) : String =
    when (Date().time - this.time) {
        in 0..1000 -> "только что"
        in 1000..45000 -> "несколько секунд назад"
        in 45000..75000 -> "минуту назад"
        in 75000..45 * MINUTES -> "${(Date().time - this.time) / MINUTES} минут назад"
        in 45 * MINUTES..75 * MINUTES -> "Час назад"
        in 75 * MINUTES..22 * HOUR -> "${(Date().time - this.time) / HOUR} часов назад"
        in 22 * HOUR..26 * HOUR -> "день назад"
        in 26 * HOUR..360 * DAY -> "${(Date().time - this.time) / DAY} дней назад"
        else -> "более года назад"
    }



enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;

   /* fun plural(value:Int) :String{
        TODO("NEED MORE KNOWLEDGE")
        val plural : String =
        when (value) {
            in 0..1  -> if (this == TimeUnits.SECOND)  "$value секунду" else ""
            in 2..4 -> "$value секунды"
            in 5..10 -> "$value секунд"
            else -> ""
        }
        return plural
    }*/
}