package com.asteam.itaghvim.presentation.person

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

// صفحه افزودن شخص
// فرم کامل و اتصال ViewModel در مراحل بعدی تکمیل می‌شود

@Composable
fun AddPersonScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "افزودن شخص جدید")
        Text(text = "مدیریت مخاطبین و یادآوری مناسبت‌ها")
    }
}
