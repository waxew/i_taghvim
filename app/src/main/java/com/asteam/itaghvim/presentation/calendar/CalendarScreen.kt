package com.asteam.itaghvim.presentation.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * صفحه اصلی تقویم آی تقویم
 */
@Composable
fun CalendarScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "تقویم آی تقویم",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "نمایش تقویم شمسی، میلادی و رویدادها در این بخش توسعه داده می‌شود",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
