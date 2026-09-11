package com.asteam.itaghvim.presentation.person

// وضعیت صفحه مدیریت اشخاص برای UI
 data class PersonUiState(
    val isLoading: Boolean = false,
    val persons: List<String> = emptyList(),
    val errorMessage: String? = null
)
