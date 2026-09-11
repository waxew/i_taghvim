package com.asteam.itaghvim.presentation.person

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/**
 * صفحه جزئیات شخص
 * در مراحل بعد به مناسبت‌های مرتبط با شخص متصل می‌شود.
 */
@Composable
fun PersonDetailScreen(
    state: PersonDetailUiState
) {
    Text(
        text = state.name
    )
}
