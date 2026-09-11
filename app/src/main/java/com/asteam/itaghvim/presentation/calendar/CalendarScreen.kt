package com.asteam.itaghvim.presentation.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * صفحه اصلی تقویم آی تقویم
 * نمایش وضعیت تقویم و آماده سازی Grid روزها
 */
@Composable
fun CalendarScreen(
    viewModel: CalendarViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "تقویم آی تقویم",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(text = "سال ${uiState.year} - ماه ${uiState.month}")
        Text(text = "روز انتخاب شده: ${uiState.selectedDay}")

        Row {
            Button(onClick = {
                viewModel.changeMonth(uiState.month - 1)
            }) {
                Text("ماه قبل")
            }

            Button(onClick = {
                viewModel.changeMonth(uiState.month + 1)
            }) {
                Text("ماه بعد")
            }
        }

        LazyVerticalGrid(
            columns = androidx.compose.foundation.lazy.grid.GridCells.Fixed(7)
        ) {
            items((1..31).toList()) { day ->
                Button(onClick = {
                    viewModel.selectDay(day)
                }) {
                    Text(day.toString())
                }
            }
        }
    }
}
