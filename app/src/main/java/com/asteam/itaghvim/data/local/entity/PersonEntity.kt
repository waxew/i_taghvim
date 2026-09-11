package com.asteam.itaghvim.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * جدول اشخاص در دیتابیس داخلی
 */
@Entity(tableName = "persons")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val birthday: String?,
    val marriageDate: String?,
    val notes: String?
)
