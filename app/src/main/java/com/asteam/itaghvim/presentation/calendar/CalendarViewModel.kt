package com.asteam.itaghvim.presentation.calendar

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ViewModel صفحه تقویم
 * مدیریت وضعیت تاریخ انتخابی و آماده سازی اتصال به موتور تقویم و رویدادها
 */
class CalendarViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CalendarUiState())
    val uiState: StateFlow<CalendarUiState> = _uiState.asStateFlow()

    fun selectDay(day: Int) {
        _uiState.value = _uiState.value.copy(
            selectedDay = day
        )
    }

    fun changeMonth(month: Int) {
        _uiState.value = _uiState.value.copy(
            month = month
        )
    }
}


data class CalendarUiState(
    val year: Int = 1405,
    val month: Int = 1,
    val selectedDay: Int = 1
)
