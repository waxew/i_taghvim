package com.asteam.itaghvim.core.calendar

/**
 * محاسبه جایگاه روز اول ماه در Grid تقویم
 */
object CalendarOffset {

    /**
     * تعداد خانه های خالی قبل از روز اول ماه
     * weekDay: 0 = Saturday ... 6 = Friday
     */
    fun firstDayOffset(weekDay: Int): Int {
        return weekDay.coerceIn(0, 6)
    }
}
