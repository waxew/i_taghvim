package com.asteam.itaghvim.presentation.notification

/**
 * مدیریت اعلان های داخلی برنامه آی تقویم
 * این کلاس در مراحل بعد به NotificationManager اندروید متصل می شود.
 */
object NotificationCenter {

    fun updateMessage(version: String): String {
        return "نسخه جدید $version آماده دریافت است"
    }
}
