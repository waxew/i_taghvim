package com.asteam.itaghvim.core.ads

/**
 * Tapsell implementation of AdProvider.
 *
 * Keeps Tapsell SDK specific code isolated from application layers.
 */
class TapsellAdProvider : AdProvider {

    override fun initialize() {
        // SDK initialization will be connected here.
    }

    override fun showRewarded(onReward: () -> Unit) {
        // Rewarded video SDK callback will be connected here.
    }

    override fun showInterstitial() {
        // Interstitial SDK callback will be connected here.
    }
}
