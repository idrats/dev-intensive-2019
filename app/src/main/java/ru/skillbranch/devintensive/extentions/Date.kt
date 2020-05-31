package ru.skillbranch.devintensive.extentions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}


fun Date.humanizeDiff(): String {

//    this.getResources().getQuantityString()

//    resources.getQuantityString(
//        R.plurals.numberOfMinute, //plural from strings.xml file
//        min, //quantity
//        min //var arg
//    )

    return when (val diff = Date().time - this.time) {
        in 0..SECOND -> "только что"
        in SECOND + 1..SECOND * 45 -> "несколько секунд назад"
        in SECOND * 45 + 1..SECOND * 75 -> "минуту назад"
        in SECOND * 75 + 1..MINUTE * 45 -> "${diff / MINUTE} минут назад"
        in MINUTE * 45 + 1..MINUTE * 75 -> "час назад"
        in MINUTE * 75 + 1..HOUR * 22 -> "${diff / HOUR} часов назад"
        in HOUR * 22 + 1..HOUR * 26 -> "день назад"
        in HOUR * 26 + 1..DAY * 360 -> "${diff / DAY} дней назад"

        else -> "более года назад"
    }
}

// Выведем данные в формате: 8 = many : 8 котов
//for (int i = 0; i <= 33; i++) {
//    String systemPlural = this.getResources().getQuantityString(R.plurals.plurals_1, i, i);
//    String catPlural = this.getResources().getQuantityString(R.plurals.plurals_2, i, i);
//    Log.i("Plurals", systemPlural + " : " + catPlural);
//}
enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}