package com.asteam.itaghvim.domain.model

/**
 * مدل دامنه مناسبت های کاربر
 */
data class CalendarEvent(
    val id: Long,
    val title: String,
    val personName: String?,
    val solarDate: String,
    val lunarDate: String?,
    val gregorianDate: String?,
    val description: String?
)
