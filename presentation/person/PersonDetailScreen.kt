package com.asteam.itaghvim.presentation.person

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/**
 * صفحه جزئیات شخص
 * نمایش اطلاعات شخص و مناسبت‌های مرتبط
 */
@Composable
fun PersonDetailScreen(
    state: PersonDetailUiState
) {
    Column {
        Text(
            text = state.name
        )

        state.events.forEach { event ->
            Text(
                text = event.title
            )
        }
    }
}
