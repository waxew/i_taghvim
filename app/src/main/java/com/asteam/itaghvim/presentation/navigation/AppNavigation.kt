package com.asteam.itaghvim.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.asteam.itaghvim.presentation.home.HomeScreen
import com.asteam.itaghvim.presentation.calendar.AddEventScreen
import com.asteam.itaghvim.presentation.calendar.CalendarScreen
import com.asteam.itaghvim.presentation.settings.SettingsScreen
import com.asteam.itaghvim.presentation.person.AddPersonScreen

private object Routes {
    const val HOME = "home"
    const val CALENDAR = "calendar"
    const val ADD_EVENT = "add_event"
    const val PERSONS = "persons"
    const val SETTINGS = "settings"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen()
        }

        composable(Routes.CALENDAR) {
            CalendarScreen()
        }

        composable(Routes.ADD_EVENT) {
            AddEventScreen()
        }

        composable(Routes.PERSONS) {
            AddPersonScreen()
        }

        composable(Routes.SETTINGS) {
            SettingsScreen()
        }
    }
}
