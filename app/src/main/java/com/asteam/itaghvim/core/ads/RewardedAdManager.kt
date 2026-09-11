package com.asteam.itaghvim.core.ads

/**
 * مدیریت تبلیغ جایزه ای تپسل
 *
 * این لایه مستقل از UI است و مسئول مدیریت جریان تبلیغ جایزه‌ای است.
 * اتصال SDK واقعی تپسل در همین نقطه انجام می‌شود.
 */
class RewardedAdManager {

    fun isReady(): Boolean {
        return false
    }

    fun showRewardedAd(callback: AdCallback) {
        // در اتصال SDK واقعی:
        // 1. درخواست تبلیغ
        // 2. نمایش تبلیغ
        // 3. اجرای onAdCompleted فقط بعد از مشاهده کامل
        // 4. جلوگیری از دادن جایزه در صورت بستن زودهنگام
        callback.onAdFailed()
    }
}
