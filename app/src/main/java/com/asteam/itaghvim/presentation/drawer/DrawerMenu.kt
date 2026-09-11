package com.asteam.itaghvim.presentation.drawer

/**
 * آیتم های اصلی منوی همبرگری
 * تمام متن های منو در یک محل مدیریت می شوند.
 */
sealed class DrawerMenu(val title: String) {
    object Settings : DrawerMenu("تنظیمات")
    object About : DrawerMenu("درباره نرم افزار")
    object Contact : DrawerMenu("تماس با ما")
    object Share : DrawerMenu("معرفی به دوستان")
    object Backup : DrawerMenu("پشتیبان گیری")
    object Update : DrawerMenu("آپدیت")
}
