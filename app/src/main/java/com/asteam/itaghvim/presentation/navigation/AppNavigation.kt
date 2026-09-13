package com.asteam.itaghvim.presentation.navigation
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.asteam.itaghvim.presentation.home.HomeScreen
import com.asteam.itaghvim.presentation.calendar.*
import com.asteam.itaghvim.presentation.settings.SettingsScreen
import com.asteam.itaghvim.presentation.person.PeopleScreen

private object Routes{const val HOME="home";const val CALENDAR="calendar";const val ADD_EVENT="add_event";const val PERSONS="persons";const val SETTINGS="settings"}
@Composable fun AppNavigation(){
 val nav=rememberNavController(); val entry by nav.currentBackStackEntryAsState(); val current=entry?.destination?.route
 val goHome:()->Unit={nav.navigate(Routes.HOME){popUpTo(Routes.HOME){inclusive=false};launchSingleTop=true}}
 BackHandler(enabled=current!=Routes.HOME){goHome()}
 Scaffold(bottomBar={NavigationBar{
  NavigationBarItem(current==Routes.HOME,{goHome()},icon={},label={Text("خانه")})
  NavigationBarItem(current==Routes.CALENDAR,{goHome();nav.navigate(Routes.CALENDAR)},icon={},label={Text("تقویم")})
  NavigationBarItem(current==Routes.PERSONS,{goHome();nav.navigate(Routes.PERSONS)},icon={},label={Text("اشخاص")})
  NavigationBarItem(current==Routes.SETTINGS,{goHome();nav.navigate(Routes.SETTINGS)},icon={},label={Text("تنظیمات")})
 }}){p->NavHost(nav,Routes.HOME,Modifier.padding(p)){
  composable(Routes.HOME){HomeScreen({nav.navigate(Routes.CALENDAR)},{nav.navigate(Routes.ADD_EVENT)},{nav.navigate(Routes.PERSONS)},{nav.navigate(Routes.SETTINGS)})}
  composable(Routes.CALENDAR){CalendarScreen()}
  composable(Routes.ADD_EVENT){AddEventScreen(onSaved=goHome)}
  composable(Routes.PERSONS){PeopleScreen()}
  composable(Routes.SETTINGS){SettingsScreen()}
 }}
}