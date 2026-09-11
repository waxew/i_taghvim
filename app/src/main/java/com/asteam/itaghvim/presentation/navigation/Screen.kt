package com.asteam.itaghvim.presentation.navigation

/**
 * مسیرهای اصلی برنامه
 */
sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Calendar : Screen("calendar")
    data object Settings : Screen("settings")
    data object Profile : Screen("profile")
    data object About : Screen("about")
}
