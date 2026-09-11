package com.asteam.itaghvim.domain.model

/**
 * مدل اطلاعات شخص برای مناسبت های شخصی
 */
data class Person(
    val id: Long = 0,
    val name: String,
    val birthday: String? = null,
    val marriageDate: String? = null,
    val notes: String? = null
)
