package com.asteam.itaghvim.data.local.mapper

import com.asteam.itaghvim.data.local.entity.PersonEntity
import com.asteam.itaghvim.domain.model.Person

fun PersonEntity.toDomain(): Person {
    return Person(
        id = id,
        name = name,
        birthday = birthday,
        marriageDate = marriageDate,
        notes = notes
    )
}

fun Person.toEntity(): PersonEntity {
    return PersonEntity(
        id = id,
        name = name,
        birthday = birthday,
        marriageDate = marriageDate,
        notes = notes
    )
}
