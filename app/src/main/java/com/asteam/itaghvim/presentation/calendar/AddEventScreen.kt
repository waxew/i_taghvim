package com.asteam.itaghvim.presentation.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * صفحه افزودن مناسبت جدید
 * فرم پایه برای اتصال به EventViewModel آماده می‌شود.
 */
@Composable
fun AddEventScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "افزودن مناسبت جدید")
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("عنوان مناسبت") }
        )
        Button(onClick = {}) {
            Text("ذخیره")
        }
    }
}
