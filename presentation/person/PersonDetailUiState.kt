package com.asteam.itaghvim.presentation.person

/**
 * وضعیت صفحه جزئیات شخص
 * این کلاس برای مدیریت State صفحه جزئیات شخص استفاده می‌شود.
 */
data class PersonDetailUiState(
    val personId: Long = 0,
    val name: String = "",
    val description: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
