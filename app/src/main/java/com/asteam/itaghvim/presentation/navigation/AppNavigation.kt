package com.asteam.itaghvim.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.asteam.itaghvim.presentation.home.HomeScreen
import com.asteam.itaghvim.presentation.calendar.*
import com.asteam.itaghvim.presentation.settings.SettingsScreen
import com.asteam.itaghvim.presentation.person.AddPersonScreen

private object Routes { const val HOME="home"; const val CALENDAR="calendar"; const val ADD_EVENT="add_event"; const val PERSONS="persons"; const val SETTINGS="settings" }

@Composable fun AppNavigation() {
 val nav=rememberNavController()
 Scaffold(bottomBar={ NavigationBar {
  NavigationBarItem(true,{nav.navigate(Routes.HOME)},icon={},label={Text("خانه")})
  NavigationBarItem(false,{nav.navigate(Routes.CALENDAR)},icon={},label={Text("تقویم")})
  NavigationBarItem(false,{nav.navigate(Routes.PERSONS)},icon={},label={Text("اشخاص")})
  NavigationBarItem(false,{nav.navigate(Routes.SETTINGS)},icon={},label={Text("تنظیمات")})
 }}){ p-> NavHost(nav,Routes.HOME,Modifier.padding(p)){
  composable(Routes.HOME){HomeScreen({nav.navigate(Routes.CALENDAR)},{nav.navigate(Routes.ADD_EVENT)},{nav.navigate(Routes.PERSONS)},{nav.navigate(Routes.SETTINGS)})}
  composable(Routes.CALENDAR){CalendarScreen()}; composable(Routes.ADD_EVENT){AddEventScreen()}; composable(Routes.PERSONS){AddPersonScreen()}; composable(Routes.SETTINGS){SettingsScreen()}
 }}
}