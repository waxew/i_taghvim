package com.asteam.itaghvim.presentation.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asteam.itaghvim.core.calendar.HolidayProvider
import com.asteam.itaghvim.domain.model.CalendarEvent
import com.asteam.itaghvim.domain.usecase.GetEventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel صفحه تقویم
 * مدیریت تاریخ انتخابی، ماه جاری، رویدادها و مناسبت ها
 */
@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CalendarUiState())
    val uiState: StateFlow<CalendarUiState> = _uiState.asStateFlow()

    init {
        observeEvents()
        updateHolidays()
    }

    private fun observeEvents() {
        viewModelScope.launch {
            getEventsUseCase().collectLatest { events ->
                _uiState.value = _uiState.value.copy(
                    events = events,
                    isLoading = false,
                    errorMessage = null
                )
            }
        }
    }

    private fun updateHolidays() {
        _uiState.value = _uiState.value.copy(
            holidays = HolidayProvider.getHolidays(_uiState.value.month)
        )
    }

    fun selectDay(day: Int) {
        _uiState.value = _uiState.value.copy(selectedDay = day)
    }

    fun changeMonth(month: Int) {
        val normalizedMonth = when {
            month < 1 -> 12
            month > 12 -> 1
            else -> month
        }

        _uiState.value = _uiState.value.copy(
            month = normalizedMonth,
            holidays = HolidayProvider.getHolidays(normalizedMonth)
        )
    }
}

