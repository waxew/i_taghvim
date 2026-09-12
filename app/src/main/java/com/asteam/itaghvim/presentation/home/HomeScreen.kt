package com.asteam.itaghvim.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onCalendar: () -> Unit = {},
    onAddEvent: () -> Unit = {},
    onPersons: () -> Unit = {},
    onSettings: () -> Unit = {}
) {
    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("آی تقویم", style = MaterialTheme.typography.headlineMedium)
        Text("تقویم هوشمند شخصی شما", style = MaterialTheme.typography.bodyMedium)
        Button(onClick = onCalendar, Modifier.fillMaxWidth()) { Text("مشاهده تقویم") }
        Button(onClick = onAddEvent, Modifier.fillMaxWidth()) { Text("افزودن رویداد") }
        OutlinedButton(onClick = onPersons, Modifier.fillMaxWidth()) { Text("مدیریت اشخاص") }
        OutlinedButton(onClick = onSettings, Modifier.fillMaxWidth()) { Text("تنظیمات") }
    }
}