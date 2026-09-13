package com.asteam.itaghvim.presentation.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asteam.itaghvim.core.calendar.CalendarConverter
import com.asteam.itaghvim.core.calendar.DateConverter
import com.asteam.itaghvim.core.calendar.HolidayProvider
import com.asteam.itaghvim.core.calendar.MonthCalculator
import com.asteam.itaghvim.domain.model.CalendarEvent
import com.asteam.itaghvim.domain.usecase.GetEventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

/**
 * ViewModel صفحه تقویم؛ تاریخ‌های سه‌گانه و رویدادهای Room را هماهنگ نگه می‌دارد.
 */
@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CalendarUiState())
    val uiState: StateFlow<CalendarUiState> = _uiState.asStateFlow()

    init {
        val today = DateConverter.gregorianToPersian(LocalDate.now())
        _uiState.value = withDate(
            _uiState.value.copy(
                year = today.year,
                month = today.month,
                selectedDay = today.day
            ),
            today.year,
            today.month,
            today.day
        )
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
        if (day !in 1..MonthCalculator.daysOfMonth(_uiState.value.year, _uiState.value.month)) return
        val state = _uiState.value.copy(selectedDay = day)
        _uiState.value = withDate(state, state.year, state.month, day)
    }

    fun changeMonth(month: Int) {
        val current = _uiState.value
        var year = current.year
        var normalizedMonth = month
        if (normalizedMonth < 1) {
            normalizedMonth = 12
            year--
        } else if (normalizedMonth > 12) {
            normalizedMonth = 1
            year++
        }

        val day = minOf(
            current.selectedDay,
            MonthCalculator.daysOfMonth(year, normalizedMonth)
        )
        _uiState.value = withDate(
            current.copy(year = year, month = normalizedMonth, selectedDay = day),
            year,
            normalizedMonth,
            day
        )
        updateHolidays()
    }

    private fun withDate(
        state: CalendarUiState,
        year: Int,
        month: Int,
        day: Int
    ): CalendarUiState {
        return state.copy(
            solarDate = "%04d/%02d/%02d".format(year, month, day),
            gregorianDate = CalendarConverter.solarToGregorian(year, month, day),
            lunarDate = CalendarConverter.solarToLunar(year, month, day)
        )
    }
}
