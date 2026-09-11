package com.asteam.itaghvim.presentation.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.hilt.lifecycle.ViewModelInject
import com.asteam.itaghvim.domain.model.CalendarEvent
import com.asteam.itaghvim.domain.usecase.AddEventUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * مدیریت منطق صفحه مناسبت ها
 * ارتباط UI با UseCase از طریق ViewModel انجام می شود.
 */
@HiltViewModel
class EventViewModel @Inject constructor(
    private val addEventUseCase: AddEventUseCase
) : ViewModel() {

    fun saveEvent(event: CalendarEvent) {
        viewModelScope.launch {
            addEventUseCase(event)
        }
    }
}
