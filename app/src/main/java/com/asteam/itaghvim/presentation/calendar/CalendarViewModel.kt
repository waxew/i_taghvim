package com.asteam.itaghvim.presentation.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
 * مدیریت تاریخ انتخابی و رویدادهای ثبت شده
 */
@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CalendarUiState())
    val uiState: StateFlow<CalendarUiState> = _uiState.asStateFlow()

    init {
        loadEvents()
    }

    private fun loadEvents() {
        viewModelScope.launch {
            getEventsUseCase().collectLatest { events ->
                _uiState.value = _uiState.value.copy(
                    events = events,
                    isLoading = false
                )
            }
        }
    }

    fun selectDay(day: Int) {
        _uiState.value = _uiState.value.copy(selectedDay = day)
    }

    fun changeMonth(month: Int) {
        _uiState.value = _uiState.value.copy(month = month)
    }
}


data class CalendarUiState(
    val year: Int = 1405,
    val month: Int = 1,
    val selectedDay: Int = 1,
    val events: List<CalendarEvent> = emptyList(),
    val isLoading: Boolean = true
)
