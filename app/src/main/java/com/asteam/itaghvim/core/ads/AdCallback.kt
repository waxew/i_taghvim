package com.asteam.itaghvim.core.ads

interface AdCallback {
    fun onAdLoaded() {}
    fun onAdShown() {}
    fun onAdCompleted() {}
    fun onAdFailed(message: String) {}
}
