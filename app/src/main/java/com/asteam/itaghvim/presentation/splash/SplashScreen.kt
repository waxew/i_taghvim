package com.asteam.itaghvim.presentation.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * صفحه شروع برنامه
 * محل قرارگیری لوگوموشن نهایی خواهد بود.
 */
@Composable
fun SplashScreen(onFinished: () -> Unit) {
    val alpha = Animatable(0f)

    LaunchedEffect(Unit) {
        alpha.animateTo(1f, tween(1000))
        onFinished()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "آی تقویم")
    }
}
