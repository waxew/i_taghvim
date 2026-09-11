package com.asteam.itaghvim.presentation.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel صفحه خانه
 * منطق UI در این لایه قرار می گیرد.
 */
@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    val state = HomeUiState()
}
