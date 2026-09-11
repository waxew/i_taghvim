package com.asteam.itaghvim.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * صفحه اصلی آی تقویم
 */
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "آی تقویم",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "تقویم هوشمند شخصی شما",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
