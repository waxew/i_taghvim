package com.asteam.itaghvim.core.ads

/**
 * قرارداد عمومی برای سرویس تبلیغات.
 *
 * لایه UI نباید مستقیماً به سرویس تبلیغاتی وابسته باشد.
 * پیاده سازی واقعی Tapsell در این لایه تزریق خواهد شد.
 */
interface AdProvider {

    fun initialize()

    fun showRewarded(onReward: () -> Unit)

    fun showInterstitial()
}
