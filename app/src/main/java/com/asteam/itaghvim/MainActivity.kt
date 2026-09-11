package com.asteam.itaghvim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import com.asteam.itaghvim.presentation.navigation.AppNavigation

/**
 * اکتیویتی اصلی برنامه آی تقویم
 * نقطه شروع UI برنامه
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppNavigation()
        }
    }
}
