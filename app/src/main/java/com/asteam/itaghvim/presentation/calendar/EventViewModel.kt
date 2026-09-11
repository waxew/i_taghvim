package com.asteam.itaghvim.presentation.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asteam.itaghvim.domain.model.CalendarEvent
import com.asteam.itaghvim.domain.usecase.AddEventUseCase
import kotlinx.coroutines.launch

/**
 * مدیریت منطق صفحه مناسبت ها
 * ارتباط UI با UseCase از طریق ViewModel انجام می شود.
 */
class EventViewModel(
    private val addEventUseCase: AddEventUseCase
) : ViewModel() {

    fun saveEvent(event: CalendarEvent) {
        viewModelScope.launch {
            addEventUseCase(event)
        }
    }
}
