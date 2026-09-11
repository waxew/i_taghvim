package com.asteam.itaghvim.presentation.person

// وضعیت فرم افزودن شخص
// این کلاس فقط وضعیت رابط کاربری را نگهداری می‌کند
// و منطق ذخیره سازی در لایه Domain انجام خواهد شد

data class AddPersonUiState(
    val name: String = "",
    val description: String = "",
    val isSaving: Boolean = false,
    val errorMessage: String? = null
)
