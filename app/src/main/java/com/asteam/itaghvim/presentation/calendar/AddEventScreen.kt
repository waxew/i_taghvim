package com.asteam.itaghvim.presentation.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.asteam.itaghvim.domain.model.CalendarEvent

/**
 * صفحه افزودن مناسبت جدید
 * اتصال فرم به EventViewModel
 */
@Composable
fun AddEventScreen(
    viewModel: EventViewModel = hiltViewModel()
) {
    var title by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "افزودن مناسبت جدید")

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("عنوان مناسبت") }
        )

        Button(
            onClick = {
                viewModel.saveEvent(
                    CalendarEvent(
                        id = 0,
                        title = title,
                        personName = null,
                        solarDate = "",
                        lunarDate = null,
                        gregorianDate = null,
                        description = null
                    )
                )
            }
        ) {
            Text("ذخیره")
        }
    }
}
