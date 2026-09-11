package com.asteam.itaghvim.domain.model

/**
 * مدل دامنه اطلاعات شخص در آی تقویم
 */
data class PersonProfile(
    val id: Long = 0,
    val name: String,
    val description: String? = null
)
