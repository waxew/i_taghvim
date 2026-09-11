package com.asteam.itaghvim.core.ads

/**
 * مدیریت تبلیغ جایزه ای تپسل
 *
 * این لایه مستقل از UI است و بعد از اتصال SDK واقعی
 * مسئول درخواست، نمایش و دریافت نتیجه تبلیغ خواهد بود.
 */
class RewardedAdManager {

    fun isReady(): Boolean {
        return false
    }

    fun showRewardedAd(onReward: () -> Unit) {
        // اتصال SDK تپسل در این بخش انجام می شود.
        // فقط بعد از مشاهده کامل تبلیغ باید onReward اجرا شود.
    }
}
