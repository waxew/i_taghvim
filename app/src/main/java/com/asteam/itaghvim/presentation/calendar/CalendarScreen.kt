package com.asteam.itaghvim.presentation.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.asteam.itaghvim.core.calendar.MonthCalculator

/** صفحه تقویم؛ ViewModel از Hilt تزریق می‌شود تا ورود به صفحه باعث کرش نشود. */
@Composable
fun CalendarScreen(viewModel: CalendarViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    val days = MonthCalculator.daysOfMonth(uiState.year, uiState.month)
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("تقویم آی تقویم", style = MaterialTheme.typography.headlineMedium)
        Text("سال ${uiState.year} - ${uiState.month}")
        Text("روز انتخاب شده: ${uiState.selectedDay}")
        Row {
            Button(onClick = { viewModel.changeMonth(uiState.month - 1) }) { Text("ماه قبل") }
            Button(onClick = { viewModel.changeMonth(uiState.month + 1) }) { Text("ماه بعد") }
        }
        LazyVerticalGrid(columns = GridCells.Fixed(7)) {
            items((1..days).toList()) { day ->
                Button(onClick = { viewModel.selectDay(day) }) { Text(day.toString()) }
            }
        }
        Text("مناسبت ها")
        uiState.holidays.forEach { Text(it) }
        Text("رویدادها")
        uiState.events.filter { it.solarDate == "${uiState.year}/${uiState.month.toString().padStart(2,'0')}/${uiState.selectedDay.toString().padStart(2,'0')}" }
            .forEach { Text(it.title) }
    }
}