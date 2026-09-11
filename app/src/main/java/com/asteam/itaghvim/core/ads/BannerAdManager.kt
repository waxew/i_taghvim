package com.asteam.itaghvim.core.ads

/**
 * Manager layer for Tapsell banner advertisements.
 *
 * This class keeps banner logic separated from Compose screens.
 * The SDK-specific implementation will be connected here after
 * the official Tapsell Android dependency is added.
 */
class BannerAdManager {

    private var loaded = false

    fun isReady(): Boolean = loaded

    fun markLoaded() {
        loaded = true
    }

    fun clear() {
        loaded = false
    }
}
