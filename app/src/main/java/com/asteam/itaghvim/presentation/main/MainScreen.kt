package com.asteam.itaghvim.presentation.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.asteam.itaghvim.presentation.components.AppHeader

/**
 * صفحه اصلی برنامه آی تقویم
 * محل اتصال Header، Drawer و محتوای صفحات است.
 */
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            AppHeader()
        }
    ) { _ ->
        // محتوای اصلی صفحات در مراحل بعد اضافه می شود.
    }
}
