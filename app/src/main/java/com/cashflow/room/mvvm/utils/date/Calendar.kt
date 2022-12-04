package com.cashflow.room.mvvm.utils.date

import java.util.*


fun getCurrentMonth(): Month {
    val calendar = Calendar.getInstance()
    return when (calendar.get(Calendar.MONTH) + 1) {
        Month.JANUARY.number -> Month.JANUARY
        Month.FEBRUARY.number -> Month.FEBRUARY
        Month.MARCH.number -> Month.MARCH
        Month.APRIL.number -> Month.APRIL
        Month.MAY.number -> Month.MAY
        Month.JUNE.number -> Month.JUNE
        Month.JULY.number -> Month.JULY
        Month.AUGUST.number -> Month.AUGUST
        Month.SEPTEMBER.number -> Month.SEPTEMBER
        Month.OCTOBER.number -> Month.OCTOBER
        Month.NOVEMBER.number -> Month.NOVEMBER
        Month.DECEMBER.number -> Month.DECEMBER
        else -> {
            Month.JANUARY
        }
    }
}

fun getCurrentYear(): Int {
    val calendar = Calendar.getInstance()
    return calendar.get(Calendar.YEAR)

}


enum class Month(
    val abreviation: String,
    val nameMonth: String,
    val brazilianName: String,
    val number: Int
) {
    JANUARY("JAN", "January", "Janeiro", 1),
    FEBRUARY("FEV", "February", "Fevereiro", 2),
    MARCH("MAR", "March", "Março", 3),
    APRIL("ABR", "April", "Abril", 4),
    MAY("MAI", "May", "Maio", 5),
    JUNE("JUN", "June", "Junho", 6),
    JULY("JUL", "July", "Julho", 7),
    AUGUST("AGO", "August", "Agosto", 8),
    SEPTEMBER("SET", "September", "Setembro", 9),
    OCTOBER("OUT", "October", "Outubro", 10),
    NOVEMBER("NOV", "November", "Novembro", 11),
    DECEMBER("DEZ", "December", "Dezembro", 12);
}

enum class Day(val nameDay: String, val dayOfWeek: Int) {
    MONDAY("Segunda", 1),
    TUESDAY("Terça", 2),
    WEDNESDAY("Quarta", 3),
    THURSDAY("Quinta", 4),
    FRIDAY("Sexta", 5),
    SATURDAY("Sábado", 6),
    SUNDAY("Domingo", 7)
}