package com.asteam.itaghvim.core.calendar

/**
 * مبدل پایه تاریخ ها
 *
 * این کلاس محل قرارگیری منطق تبدیل بین تقویم شمسی، قمری و میلادی است.
 * در نسخه های بعدی الگوریتم کامل تبدیل در این بخش قرار می گیرد.
 */
object CalendarConverter {

    fun convertToSolar(year: Int, month: Int, day: Int): String {
        // تبدیل تاریخ به شمسی در نسخه بعد تکمیل می شود
        return "$year/$month/$day"
    }

    fun convertToGregorian(year: Int, month: Int, day: Int): String {
        // تبدیل تاریخ به میلادی در نسخه بعد تکمیل می شود
        return "$year/$month/$day"
    }
}
