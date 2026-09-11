package com.asteam.itaghvim.core.ads

/**
 * وضعیت قابلیت های باز شده با تبلیغ جایزه ای
 */
data class RewardState(
    val rewarded: Boolean = false,
    val rewardCount: Int = 0
)
