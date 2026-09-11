package com.asteam.itaghvim.core.vip

/**
 * مدیریت وضعیت اشتراک VIP
 * در نسخه های بعدی به دیتابیس و سیستم خرید متصل می شود.
 */
object VipManager {

    var isVipActive: Boolean = false

    fun shouldShowAds(): Boolean {
        return !isVipActive
    }
}
