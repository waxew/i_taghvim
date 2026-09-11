package com.asteam.itaghvim.core.ads

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Compose wrapper for banner advertisements.
 *
 * SDK rendering will be connected here after the Tapsell SDK dependency
 * and native view integration are added.
 */
@Composable
fun BannerAdComposable(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        // Tapsell banner view will be hosted here.
    }
}
