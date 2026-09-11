package com.asteam.itaghvim.presentation.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.asteam.itaghvim.core.config.AppConfig

/**
 * سربرگ مشترک برنامه آی تقویم
 *
 * ساختار نهایی:
 * - سمت راست: Drawer همبرگری
 * - وسط: لوگو یا نام برنامه
 * - سمت چپ: دسترسی به بخش های برنامه
 */
@Composable
fun AppHeader() {
    CenterAlignedTopAppBar(
        title = {
            Text(text = AppConfig.APP_NAME)
        }
    )
}
