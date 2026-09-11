package com.asteam.itaghvim.presentation.drawer

/**
 * آیتم های منوی کناری برنامه
 */
data class DrawerItem(
    val title: String,
    val iconName: String
)

object DrawerItems {
    val items = listOf(
        DrawerItem("تنظیمات", "settings"),
        DrawerItem("درباره نرم افزار", "about"),
        DrawerItem("تماس با ما", "contact"),
        DrawerItem("معرفی به دوستان", "share"),
        DrawerItem("پشتیبان گیری", "backup"),
        DrawerItem("آپدیت", "update")
    )
}
