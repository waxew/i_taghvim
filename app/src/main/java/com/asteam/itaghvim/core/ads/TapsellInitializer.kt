package com.asteam.itaghvim.core.ads

import android.content.Context

/**
 * Central place for initializing Tapsell SDK.
 *
 * SDK initialization is kept isolated from UI so the ad provider can be
 * replaced or configured without changing screens.
 */
object TapsellInitializer {

    private var initialized = false

    fun initialize(context: Context) {
        if (initialized) return

        // Official Tapsell SDK initialization will be connected here.
        // App key remains isolated inside TapsellConfig.
        initialized = true
    }
}
