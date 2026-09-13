package com.asteam.itaghvim.presentation.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.weight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.asteam.itaghvim.core.calendar.CalendarConverter
import com.asteam.itaghvim.core.calendar.MonthCalculator

/**
 * تقویم شمسی با انتخاب روز، تبدیل سه‌گانه تاریخ و نمایش رویدادهای Room.
 */
@Composable
fun CalendarScreen(
    onAddEvent: () -> Unit = {},
    viewModel: CalendarViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val monthDays = MonthCalculator.daysOfMonth(uiState.year, uiState.month)
    val firstDayOffset = CalendarConverter.firstWeekdayOfSolarMonth(uiState.year, uiState.month)
    val dayCells = List(firstDayOffset) { null } + (1..monthDays).map { it }
    val monthPrefix = "%04d/%02d/".format(uiState.year, uiState.month)
    val eventDays = uiState.events
        .filter { it.solarDate.startsWith(monthPrefix) }
        .mapNotNull { it.solarDate.substringAfterLast('/').toIntOrNull() }
        .toSet()
    val selectedEvents = uiState.events.filter { it.solarDate == uiState.solarDate }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
            ) {
                TextButton(onClick = { viewModel.changeMonth(uiState.month - 1) }) {
                    Text("ماه قبل")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "${MonthCalculator.monthName(uiState.month)} ${uiState.year}",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text("تقویم شمسی", style = MaterialTheme.typography.bodySmall)
                }
                TextButton(onClick = { viewModel.changeMonth(uiState.month + 1) }) {
                    Text("ماه بعد")
                }
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                listOf("شنبه", "یکشنبه", "دوشنبه", "سه‌شنبه", "چهارشنبه", "پنجشنبه", "جمعه")
                    .forEach { dayName ->
                        Text(
                            text = dayName,
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(7),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(dayCells) { day ->
                    if (day == null) {
                        Spacer(Modifier.aspectRatio(1f).padding(2.dp))
                    } else {
                        val selected = day == uiState.selectedDay
                        Button(
                            onClick = { viewModel.selectDay(day) },
                            modifier = Modifier
                                .aspectRatio(1f)
                                .padding(2.dp),
                            contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (selected) {
                                    MaterialTheme.colorScheme.primary
                                } else {
                                    MaterialTheme.colorScheme.surfaceVariant
                                },
                                contentColor = if (selected) {
                                    MaterialTheme.colorScheme.onPrimary
                                } else {
                                    MaterialTheme.colorScheme.onSurfaceVariant
                                }
                            )
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(day.toString())
                                if (day in eventDays) {
                                    Text("•", style = MaterialTheme.typography.titleMedium)
                                }
                            }
                        }
                    }
                }
            }

            Text("تاریخ انتخاب‌شده: ${uiState.solarDate}")
            Text("میلادی: ${uiState.gregorianDate}   قمری: ${uiState.lunarDate}")

            if (uiState.holidays.isNotEmpty()) {
                Text("مناسبت‌های این ماه: ${uiState.holidays.joinToString("، ")}")
            }

            if (selectedEvents.isEmpty()) {
                Text("برای این روز رویدادی ثبت نشده است.")
            } else {
                Text("رویدادهای این روز", style = MaterialTheme.typography.titleMedium)
                selectedEvents.forEach { event ->
                    Text("• ${event.title}${event.personName?.takeIf { it.isNotBlank() }?.let { " - $it" } ?: ""}")
                }
            }

            Button(
                onClick = onAddEvent,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("افزودن رویداد برای این روز")
            }
        }
    }
}
