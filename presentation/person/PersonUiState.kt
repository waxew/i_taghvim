package com.asteam.itaghvim.presentation.person

import com.asteam.itaghvim.domain.model.Person

// وضعیت صفحه مدیریت اشخاص برای UI
data class PersonUiState(
    val isLoading: Boolean = false,
    val persons: List<Person> = emptyList(),
    val errorMessage: String? = null
)
