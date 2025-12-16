package com.fnndev.debtbook.data.mapper

import com.fnndev.debtbook.data.local.entity.PersonEntity
import com.fnndev.debtbook.domain.model.Person

fun PersonEntity.toDomain(): Person {
    return Person(
        personId = personId,
        fullName = fullName,
        mobile = mobile,
        description = description
    )
}

fun Person.toEntity(): PersonEntity {
    return PersonEntity(
        personId = personId,
        fullName = fullName,
        mobile = mobile,
        description = description
    )
}