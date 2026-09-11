package com.asteam.itaghvim.core.ads

/**
 * مدیریت مرکزی تبلیغات
 *
 * اتصال SDK تپسل در این لایه انجام می شود
 * تا UI مستقیما به سرویس تبلیغات وابسته نباشد.
 */
class AdManager {

    fun showRewardedAd(onReward: () -> Unit) {
        // اتصال SDK تپسل در مرحله بعد
        // پس از دریافت callback موفق، جایزه اعمال می شود.
    }

    fun showInterstitialAd() {
        // اتصال تبلیغ تمام صفحه تپسل
    }

    fun loadBannerAd() {
        // محل اتصال Banner View تپسل
    }
}
