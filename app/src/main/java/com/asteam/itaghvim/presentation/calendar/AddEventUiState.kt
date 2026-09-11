package com.asteam.itaghvim.presentation.calendar

/**
 * وضعیت صفحه افزودن مناسبت
 */
data class AddEventUiState(
    val personName: String = "",
    val title: String = "",
    val dateSolar: String = "",
    val dateLunar: String = "",
    val dateGregorian: String = "",
    val description: String = ""
)
