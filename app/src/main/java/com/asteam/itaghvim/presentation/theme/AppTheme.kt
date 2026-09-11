package com.asteam.itaghvim.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

/**
 * تم مرکزی برنامه
 * برای یکپارچه سازی ظاهر تمام صفحات استفاده می شود.
 */
@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme {
        content()
    }
}
