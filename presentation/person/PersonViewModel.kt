package com.asteam.itaghvim.presentation.person

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asteam.itaghvim.domain.usecase.GetPersonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// ViewModel مدیریت منطق صفحه اشخاص
@HiltViewModel
class PersonViewModel @Inject constructor(
    private val getPersonsUseCase: GetPersonsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PersonUiState())
    val state: StateFlow<PersonUiState> = _state

    // دریافت لیست اشخاص از لایه Domain
    fun loadPersons() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            // اتصال واقعی Flow بعد از تکمیل Repository انجام می‌شود
            _state.value = _state.value.copy(isLoading = false)
        }
    }
}
